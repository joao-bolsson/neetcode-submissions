/*

 i
[2,20,4,10,3,4,5]

*/


class Solution {
    public int longestConsecutive(int[] nums) {       
        if (nums.length == 1) return 1;
        var set = new HashSet<Integer>();
        for (var n : nums) set.add(n);

        var visited = new HashSet<Integer>();
        
        var longest = 0;
        for (var i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            
            var curr = 1;
            var num = nums[i]; // start of sequence
            while (set.contains(++num)) {
                curr++; // keep increasing sequence
                visited.add(num);
            }

            longest = Math.max(longest, curr);
        }
        return longest;
    }
}
