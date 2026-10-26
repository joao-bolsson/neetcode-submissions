/*

i                          j
Was it a car or a cat I saw?

*/

class Solution {

    public boolean isAlphanumeric(char l) {
        return l >= 'A' && l <= 'z' || l >= '0' && l <= '9';
    }

    public boolean isPalindrome(String s) {
        var a = new StringBuilder();
        for (var i = 0; i < s.length(); i++) 
            if (isAlphanumeric(s.charAt(i))) a.append(s.charAt(i));

        var b = new StringBuilder();
        for (var i = s.length() - 1; i >= 0; i--) 
            if (isAlphanumeric(s.charAt(i))) b.append(s.charAt(i));

        return a.toString().equalsIgnoreCase(b.toString());
    }
}
