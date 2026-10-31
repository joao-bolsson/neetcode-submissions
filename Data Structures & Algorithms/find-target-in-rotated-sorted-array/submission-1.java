/*
        r
      m
        l
3,4,5,6,1,2

*/
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        /*
                e
                s
                  m
        4,5,6,7,0,1,2
        */
        // find the minimum
        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] >= nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int min = nums[l];

        int start = 0, end = nums.length - 1;
        if (target >= nums[l] && target <= nums[nums.length - 1]) {
            start = l;
        } else {
            end = l - 1;
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
