class Solution {
    public String foreignDictionary(String[] words) {
        // char -> next neighboors that comes after me in the dictionary
        var map = new HashMap<Character, List<Character>>();

        var indegree = new int[26];
        Arrays.fill(indegree, -1);

        for (var word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] == -1) indegree[c - 'a'] = 0;
            }
        }

        for (var j = 1; j < words.length; j++) {
            var prev = words[j-1];
            var curr = words[j];

            if (prev.length() > curr.length() && prev.startsWith(curr)) return "";

            // find the first letter that differs
            for (var i = 0; i < Math.min(prev.length(), curr.length()); i++) {
                var a = prev.charAt(i);
                var b = curr.charAt(i);

                if (a != b) {
                    map.computeIfAbsent(a, k -> new ArrayList<Character>()).add(b);
                    indegree[b - 'a']++;
                    break;
                }
            }
        }

        var queue = new LinkedList<Character>();

        for (var i = 0; i < indegree.length; i++) if (indegree[i] == 0) queue.add((char)('a' + i));

        var path = new StringBuilder();

        while (!queue.isEmpty()) {
            var size = queue.size();
            while (size -- > 0) {
                var curr = queue.pop();
                path.append(curr);

                var list = map.getOrDefault(curr, List.of());
                for (var next : list) {
                    indegree[next - 'a']--;
                    if (indegree[next - 'a'] == 0) queue.add(next);
                }
            }
        }

        for (var degree : indegree) if (degree > 0) return "";
        
        // need to check for cycles
        int totalNodes = 0;
        for (int d : indegree) if (d != -1) totalNodes++;
        return path.length() == totalNodes ? path.toString() : "";
    }
}