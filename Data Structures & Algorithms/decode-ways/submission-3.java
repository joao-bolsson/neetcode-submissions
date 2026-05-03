/*

4 2 1 0

  i
1 2 7


*/

class Solution {
    public int numDecodings(String s) {
        var dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for (var i = s.length() - 1; i >= 0; i--) {
            var d = s.charAt(i);
            if (d == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];

            if (i < s.length() - 1) {
                if (d == '1' || (d == '2' && s.charAt(i+1) <= '6')) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
