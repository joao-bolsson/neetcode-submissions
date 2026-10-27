class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;

        var maxArea = Integer.MIN_VALUE;

        while (left < right) {
            var width = right - left;
            var height = Math.min(heights[left], heights[right]);

            maxArea = Math.max(maxArea, width * height);

            if (heights[right] < heights[left]) right--;
            else left++;
        }

        return maxArea;
    }
}
