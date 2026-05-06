class Solution {
    public String foreignDictionary(String[] words) {
        var map = new HashMap<Character, Set<Character>>();

        var ind = new int[26];
        Arrays.fill(ind, -1);
        var resSize = 0;
        for (var w : words) {
            for (var l : w.toCharArray()) {
                if (ind[l - 'a'] == -1) resSize++;
                ind[l - 'a'] = 0;
            }
        }

        for (var i = 1; i < words.length; i++) {
            var prev = words[i-1];
            var curr = words[i];

            if (prev.length() > curr.length() && prev.startsWith(curr)) return ""; // invalid state

            for (var j = 0; j < Math.min(prev.length(), curr.length()); j++) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    if (!map.getOrDefault(prev.charAt(j), Set.of()).contains(curr.charAt(j))) ind[curr.charAt(j) - 'a']++;
                    map.computeIfAbsent(prev.charAt(j), k -> new HashSet<Character>()).add(curr.charAt(j));
                    break;
                }
            }
        }

        var queue = new LinkedList<Character>();
        for (var i = 0; i < ind.length; i++) if (ind[i] == 0) queue.add((char)('a' + i));

        var alphabet = "";

        while(!queue.isEmpty()) {
            var curr = queue.pop();

            alphabet += curr;

            var neig = map.getOrDefault(curr, Set.of());
            for (var next : neig) {
                ind[next - 'a']--;
                if (ind[next - 'a'] == 0) queue.add(next);
            }
        }

        return alphabet.length() == resSize ? alphabet : "";
    }
}