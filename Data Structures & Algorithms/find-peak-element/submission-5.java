/*

     i
[1,2,3,1]


 s           e
[1,1,1,3,3,3,4]

     i
[1,2]

*/
class Solution {

    int search(int start, int end, int[] nums) {
        if (start == end) {
            return start;
        }
        
        int mid = start + (end - start) / 2;

        if (nums[mid] > nums[mid + 1]) return search(start, mid, nums); // left
        return search(mid + 1, end, nums);
    }

    public int findPeakElement(int[] nums) {
        return search(0, nums.length - 1, nums);
    }
}