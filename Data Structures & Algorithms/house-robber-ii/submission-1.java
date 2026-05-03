/*

3 4 4

*/

class Solution {

    int backtrack(int i, int end, int[] nums, int[][] dp) {
        if (i >= end) return 0;

        // rob
        if (dp[i][0] == -1) dp[i][0] = nums[i] + backtrack(i+2, end, nums, dp);

        // not rob
        if (dp[i][1] == -1) dp[i][1] = backtrack(i+1, end, nums, dp);

        return Math.max(dp[i][0], dp[i][1]);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        var dp1 = new int[nums.length][2]; // rob/not rob
        var dp2 = new int[nums.length][2]; // rob/not rob
        for (var i = 0; i < nums.length; i++) {
            Arrays.fill(dp1[i], -1);
            Arrays.fill(dp2[i], -1);
        }

        return Math.max(
            backtrack(0, nums.length - 1, nums, dp1),
            backtrack(1, nums.length, nums, dp2)
        );
    }
}
