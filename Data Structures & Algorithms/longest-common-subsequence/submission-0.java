/*

a b c d

a c x

*/

class Solution {

    record Key(int i, int j) {}

    Map<Key, Integer> memo = new HashMap<>();

    int backtrack(int i, int j, String s1, String s2) {
        var key = new Key(i, j);
        if (i >= s1.length() || j >= s2.length()) return 0; // out of bounds, nothing to compare

        if (memo.containsKey(key)) return memo.get(key);

        var ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            // increment both
            ans = 1 + backtrack(i+1, j+1, s1, s2);
        } else {
            ans = Math.max(
                backtrack(i+1, j, s1, s2),
                backtrack(i, j+1, s1, s2)
            );
        }
        memo.put(key, ans);
        return ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return backtrack(0, 0, text1, text2);
    }
}
