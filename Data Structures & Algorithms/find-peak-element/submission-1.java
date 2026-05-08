/*

     i
[1,2,3,1]


             i
[1,1,1,3,3,3,4]

     i
[1,2]

*/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length >= 2) {
            if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
            if (nums[0] > nums[1]) return 0;
        }
        for (var i = 0; i < nums.length; i++) {
            var left = i == 0 ? Integer.MIN_VALUE : nums[i-1];
            var curr = nums[i];
            var right = i == nums.length - 1 ? Integer.MIN_VALUE : nums[i+1];

            if (curr > left && curr > right) return i;

            if (curr == left) continue;
            if (curr > left && curr <= right) {
                i++;
            } else {
                return i-1;
            }
        }
        return -1;
    }
}