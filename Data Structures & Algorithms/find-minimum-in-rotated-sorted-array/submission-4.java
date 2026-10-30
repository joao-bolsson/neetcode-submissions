/*

    r
l
    m
4,5,0,1,2,3

*/


class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        if (nums.length == 1) return nums[0];

        while (l < r) {
            int mid = (l+r) / 2;

            if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}