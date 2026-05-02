/*
              i
nums = [1,1,3,3]

two options: rob or not rob the curr house
*/

class Solution {

    int backtrack(int i, int[] nums, int[][] dp) {
        if (i >= nums.length) return 0;

        // robbing
        if (dp[i][0] == -1) dp[i][0] = nums[i] + backtrack(i+2, nums, dp);

        // not robbing
        if (dp[i][1] == -1) dp[i][1] = backtrack(i+1, nums, dp);

        return Math.max(
            dp[i][0],
            dp[i][1]
        );
    }

    public int rob(int[] nums) {
        var dp = new int[nums.length][2];
        for (var d : dp) Arrays.fill(d, -1);

        return backtrack(0, nums, dp);
    }
}
