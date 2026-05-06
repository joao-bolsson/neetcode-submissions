/*


in the past 4 seconds

curr = 400


396

curr = 301-300 -> 1

300
3
2
1

timestamp = 4
approach 1:
    stack, while peek >= curr - timestamp: pop to a list
    push all from list
    return list.size

*/
class HitCounter {

    Deque<Integer> stack = new ArrayDeque<Integer>();

    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

    public HitCounter() {
        
    }
    
    // seconds
    public void hit(int timestamp) {
        if (!counts.containsKey(timestamp)) {
            stack.push(timestamp);
            counts.put(timestamp, 1);
        } else {
            counts.put(timestamp, counts.get(timestamp) + 1);
        }
    }
    
    public int getHits(int timestamp) {
        var list = new ArrayList<Integer>();
        var hits = 0;
        while (!stack.isEmpty() && stack.peek() > timestamp - 300) {
            var t = stack.pop();
            hits += counts.get(t);
            list.add(t);
        }
        for (var i = list.size() - 1; i >= 0; i--) stack.push(list.get(i));
        return hits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
