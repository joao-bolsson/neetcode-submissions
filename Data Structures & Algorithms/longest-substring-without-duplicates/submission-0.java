class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        var set = new HashSet<Character>();
        int l = 0, r = 0;

        while (l < s.length() && r < s.length()) {

            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
            }

            maxLength = Math.max(maxLength, r - l);

            while (l < r && r < s.length() && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
        }

        return maxLength;
    }
}
