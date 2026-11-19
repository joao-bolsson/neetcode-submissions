/*

aaa


*/


class Solution {

    boolean isPalindrome(int l, int r, String s) {
        return l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r);
    }

    public int countSubstrings(String s) {
        var count = 0;
        for (var i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;

            while (isPalindrome(l--, r++, s)) count++;

            // even length
            l = i;
            r = i+1;
            while (isPalindrome(l--, r++, s)) count++;
        }
        return count;
    }
}
