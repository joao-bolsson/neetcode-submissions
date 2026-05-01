class Solution {
    public String foreignDictionary(String[] input) {
        var map = new HashMap<Character, List<Character>>();
        
        var indegree = new HashMap<Character, Integer>();
        
        for (var word : input) {
            for (var l : word.toCharArray()) indegree.put(l, 0);
        }
        
        for (var i = 1; i < input.length; i++) {
            var prev = input[i-1];
            var curr = input[i];
            
            if (prev.length() > curr.length() && prev.startsWith(curr)) return "";
            
            for (var j = 0; j < prev.length() && j < curr.length(); j++) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    var first = prev.charAt(j);
                    var sec = curr.charAt(j);
                    
                    map.computeIfAbsent(first, k -> new ArrayList<Character>()).add(sec);
                    indegree.put(sec, indegree.get(sec) + 1);
                    break;
                }
            }
        }
        
        var queue = new LinkedList<Character>();
        
        for (var entry : indegree.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }
        
        var res = new StringBuilder();
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            res.append(curr);
            
            for (var next : map.getOrDefault(curr, List.of())) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        
        return res.length() < indegree.size() ? "" : res.toString();
    }
}