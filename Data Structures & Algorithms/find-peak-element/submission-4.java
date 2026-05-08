/*

     i
[1,2,3,1]


 s           e
[1,1,1,3,3,3,4]

     i
[1,2]

*/
class Solution {

    boolean isPeak(int i, int[] nums) {
        var left = i == 0 ? Long.MIN_VALUE : nums[i-1];
        var curr = nums[i];
        var right = i == nums.length - 1 ? Long.MIN_VALUE : nums[i+1];
        return curr > left && curr > right;
    }

    int search(int start, int end, int[] nums) {
        if (start > end) return -1;
        if (start == end) {
            if (isPeak(start, nums)) return start;
            return -1; // not found
        }

        if (isPeak(start, nums)) return start;
        if (isPeak(end, nums)) return end;
        
        int mid = (start + end) / 2;
        if (isPeak(mid, nums)) return mid;

        var left = search(start+1, mid-1, nums);
        if (left > -1) return left;
        return search(mid, end-1, nums);
    }

    public int findPeakElement(int[] nums) {
        return search(0, nums.length-1, nums);
    }
}