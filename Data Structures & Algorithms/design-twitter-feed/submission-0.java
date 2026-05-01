class Twitter {

    public Twitter() {
        
    }

    record Tweet(int timestamp, int tweetId) implements Comparable<Tweet>{
        public int compareTo(Tweet other) {
            return timestamp - other.timestamp;
        }
    }

    // userId -> [Tweets]
    Map<Integer, Deque<Tweet>> userTweets = new HashMap<>();

    Map<Integer, Set<Integer>> userFollowings = new HashMap<>();

    int timestamp = 0;

    public void postTweet(int userId, int tweetId) {
        // max heap
        userTweets.computeIfAbsent(userId, k -> new LinkedList<Tweet>()).add(new Tweet(timestamp++, tweetId));

        var pq = userTweets.get(userId);
        
        if (pq.size() > 10) {
            pq.pollFirst();
            userTweets.put(userId, pq);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        var pq = new PriorityQueue<Tweet>(Collections.reverseOrder()); // max heap
        
        var ids = userFollowings.getOrDefault(userId, new HashSet<Integer>());
        ids.add(userId);
        ids.forEach(followeeId -> {
            var otherTweets = userTweets.getOrDefault(followeeId, new LinkedList<Tweet>());
            pq.addAll(otherTweets);
        });

        var list = new ArrayList<Integer>();
        while (!pq.isEmpty() && list.size() < 10) list.add(pq.poll().tweetId);
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowings.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowings.computeIfAbsent(followerId, k -> new HashSet<Integer>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */