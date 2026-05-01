class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        var map = new HashMap<Character, Integer>();

        for (var i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        for (var i = 1; i < words.length; i++) {
            var prev = words[i-1];
            var curr = words[i];

            if (prev.length() > curr.length() && prev.startsWith(curr)) return false;

            for (var j = 0; j < Math.min(prev.length(), curr.length()); j++) {
                var prevIdx = map.get(prev.charAt(j));
                var currIdx = map.get(curr.charAt(j));

                if (currIdx == prevIdx) continue;
                if (currIdx > prevIdx) break;
                if (currIdx < prevIdx) return false;
            }
        }

        return true;
    }
}