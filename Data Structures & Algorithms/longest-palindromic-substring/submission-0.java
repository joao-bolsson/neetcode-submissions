class Solution {

    boolean isPalindrome(int l, int r, String s) {
        return l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r);
    }

    public String longestPalindrome(String s) {
        var res = "";
        for (var i = 0; i < s.length(); i++) {
            // odd length: expanding from the center
            int l = i, r = i;

            while (isPalindrome(l, r, s)) {
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while (isPalindrome(l, r, s)) {
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
