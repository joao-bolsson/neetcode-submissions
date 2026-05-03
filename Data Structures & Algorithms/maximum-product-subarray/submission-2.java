/*

maxProd

        i
[1,2,-3,4]


1   1  -4  1

[-2,3,-4]


-4 or 1
3 or -12
-6 or 24


1    2   -6 -24
-24 -24 -12  4

       i
1 2 -3 4


currMin = -6
currMax = 2
*/
class Solution {
    public int maxProduct(int[] nums) {
        var res = Integer.MIN_VALUE;
        for (var n : nums) res = Math.max(res, n);

        int currMin = 1, currMax = 1; 
        for (var n : nums) {
            var tmp = currMax * n;
            currMax = Math.max(n * currMax, n * currMin);
            currMax = Math.max(currMax, n);

            res = Math.max(res, currMax);
            
            currMin = Math.min(tmp, n * currMin);
            currMin = Math.min(currMin, n);
        }

        return res;
    }
}
