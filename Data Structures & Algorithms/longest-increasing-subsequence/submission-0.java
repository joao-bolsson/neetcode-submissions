/*

   i
[0,3,1,3,2,3]

       j
           i
[0,1,0,3,2,3]

- when sees a num[i] > prevy
    - include
    - not include
        - backtrack

*/
class Solution {

    public int lengthOfLIS(int[] nums) {
        var lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for (var i = 1; i < nums.length; i++) {
            for (var j = 0; j < i; j++) {
                if (nums[i] > nums[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        var ans = 1;
        for (var l : lis) ans = Math.max(ans, l);
        return ans;
    }
}
