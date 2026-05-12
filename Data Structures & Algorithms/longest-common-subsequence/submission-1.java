class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        var n = text1.length();
        var m = text2.length();
        var dp = new int[m+1];

        for (var i = 1; i < n+1; i++) {
            var curr = new int[dp.length];
            for (var j = 1; j < m + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = 1 + dp[j-1]; 
                } else {
                    curr[j] = Math.max(curr[j-1], dp[j]);
                }
            }
            dp = curr;
        }

        return dp[m];
    }
}
