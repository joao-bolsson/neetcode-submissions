class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // monotonic queues

        // increasing order
        var min = new ArrayDeque<Integer>(); // [2,4,5] 1
        // decreasing order
        var max = new ArrayDeque<Integer>(); // [11,10]

        var maxSize = 0;
        var l = 0;
        for (var r = 0; r < nums.length; r++) {
            var n = nums[r];

            while (!min.isEmpty() && min.peekLast() > n) min.pollLast();
            while (!max.isEmpty() && max.peekLast() < n) max.pollLast();

            min.add(n);
            max.add(n);

            while (!max.isEmpty() && !min.isEmpty() && Math.abs(max.peekFirst() - min.peekFirst()) > limit) {
                if (nums[l] == min.peekFirst()) min.pollFirst();
                if (nums[l] == max.peekFirst()) max.pollFirst();
                l++;
            }

            maxSize = Math.max(maxSize, r - l + 1);
        }

        return maxSize;
    }
}