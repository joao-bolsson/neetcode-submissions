class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();

        for (var n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}