/*

i
1 0 1 2

*/

class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    int backtrack(int i, String s) {
        if (cache.containsKey(i)) return cache.get(i);
        if (i >= s.length()) {
            return 1;
        }
        var res = 0;
        var sub = s.charAt(i);
        if (sub >= '1' && sub <= '9') {
            res += backtrack(i+1, s);

            if (sub >= '1' && sub <= '2' && i < s.length() - 1) {
                var str = s.charAt(i) + "" + s.charAt(i+1);
                var val = Integer.parseInt(str);
                if (val >= 10 && val <= 26) {
                    res += backtrack(i+2, s);
                }
            }
        }
        cache.put(i, res);
        return res;
    }

    public int numDecodings(String s) {
        return backtrack(0, s);
    }
}
