/*

[2,-3,4,-2,2,1,-1,4]

[2, Math.max(nums[i], nums[i] + nums[i-1])]

[2, -1,4,2,4,5,4,8]

*/

class Solution {
    public int maxSubArray(int[] nums) {
        var max = nums[0];
        for (var i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
