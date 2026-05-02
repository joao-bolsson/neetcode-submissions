class Solution {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap

        for (var s : stones) pq.add(s);

        while (pq.size() >= 2) {
            var y = pq.poll();
            var x = pq.poll();

            if (x == y) continue;
            
            pq.add(y-x);
        }

        if (pq.isEmpty()) return 0;
        return pq.poll();
    }
}