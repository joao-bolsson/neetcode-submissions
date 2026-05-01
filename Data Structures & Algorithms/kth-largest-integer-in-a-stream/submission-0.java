class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // min heap

    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (var n : nums) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return pq.peek(); // O(1)
    }
}