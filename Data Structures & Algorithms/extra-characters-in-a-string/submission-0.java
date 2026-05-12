class Solution {

    int dfs(int i, String s, Set<String> dict, int[] memo) {
        if (i >= s.length()) return 0; // no characters left

        if (memo[i] != -1) return memo[i];

        var ans = 1 + dfs(i+1, s, dict, memo); // skip the curr char
        
        for (var j = i+1; j <= s.length(); j++) {
            if (dict.contains(s.substring(i, j))) ans = Math.min(ans, dfs(j, s, dict, memo));
        }
        memo[i] = ans;
        return ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        var dict = new HashSet<String>();
        for (var d : dictionary) dict.add(d);

        var memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s, dict, memo);
    }
}