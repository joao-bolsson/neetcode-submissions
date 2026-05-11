/*

aba  abacate

abacate aba -> invalid order


                          i
["hrn","hrf","er","enn","rfnn"]

topological sort

1. initialize indegree with all letters or words, with 0

n -> f
h -> e
r -> n
e -> r
*/

class Solution {
    public String foreignDictionary(String[] words) {

        var map = new HashMap<Character, List<Character>>();

        var indegree = new HashMap<Character, Integer>();
        for (var w : words) for (var l : w.toCharArray()) indegree.put(l, 0);

        for (var i = 1; i < words.length; i++) {
            var prev = words[i-1];
            var curr = words[i];

            if (prev.startsWith(curr) && prev.length() > curr.length()) return ""; // invalid order

            // find the first letter where prev and curr diffs
            var k = 0;
            while (k < Math.min(prev.length(), curr.length())) {
                if (prev.charAt(k) != curr.charAt(k)) {
                    var currL = curr.charAt(k);
                    indegree.put(currL, indegree.get(currL) + 1);

                    map.computeIfAbsent(prev.charAt(k), w -> new ArrayList<Character>()).add(currL);
                    break;
                }
                k++;
            }
        }

        // topological sort
        var queue = new LinkedList<Character>();
        for (var entry : indegree.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }

        var ans = "";

        while (!queue.isEmpty()) {
            var size = queue.size();

            while (size-- > 0) {
                var curr = queue.pop();

                ans += curr;

                for (var next : map.getOrDefault(curr, List.of())) {
                    var val = indegree.get(next) - 1;
                    indegree.put(next, val);
                    if (val == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return ans.length() == indegree.size() ? ans : "";
    }
}
