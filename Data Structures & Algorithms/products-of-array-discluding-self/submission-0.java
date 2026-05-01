class Solution {
    public int[] productExceptSelf(int[] nums) {
        var ans = new int[nums.length];

        var zeroPos = -1;
        var res = 1;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroPos != -1) return ans; // two or more zeros: array filled with zeroes
                zeroPos = i;
                continue;
            }
            res *= nums[i];
        }

        if (zeroPos != -1) {
            ans[zeroPos] = res;
        } else {
            for (var i = 0; i < nums.length; i++) {
                ans[i] = (int) (res * Math.pow(nums[i], -1));
            }
        }

        return ans;
    }
}