class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        System.out.println(Arrays.toString(strs));
        var longest = strs[0];

        for (var i = 1; i < strs.length && !longest.isEmpty(); i++) {
            while (!longest.isEmpty() && !strs[i].startsWith(longest)) {
                longest = longest.substring(0, longest.length() - 1);
            }
        }

        return longest;
    }
}