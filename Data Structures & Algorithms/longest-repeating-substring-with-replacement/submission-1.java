class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;

        var winLen = 1;
        var highestFreq = 1;
        int len = 0;

        var map = new HashMap<Character, Integer>();
        
        while (l < s.length() && r < s.length()) {
            var curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            var maxF = getHighestFreq(map);
            
            while ((r - l + 1) - maxF > k && l < r) {
                // invalid window
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }

    int getHighestFreq(Map<Character, Integer> map) {
        var highestFreq = 1;
        var it = map.values().iterator();
        while (it.hasNext()) { // O(26)
            highestFreq = Math.max(highestFreq, it.next());
        }
        return highestFreq;
    }
}
