/*
    x             
    * * 
          i
s
c a t s a n d d o g o l


1. is there any word in dict that starts with s.charAt(0)?
    yes: keep going
    no: return false
*/
class Solution {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        void addWord(String s) {
            var curr = root;

            for (var i = 0; i < s.length(); i++) {
                var l = s.charAt(i);

                if (!curr.children.containsKey(l)) curr.children.put(l, new Node());
                curr = curr.children.get(l);
            }
            curr.isWord = true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        for (var word : wordDict) trie.addWord(word);

        var queue = new LinkedList<Integer>();
        queue.add(0); // start

        var visited = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            var start = queue.pop();

            if (visited.contains(start)) continue;
            visited.add(start);

            var curr = trie.root;

            for (var i = start; i <= s.length(); i++) {
                if (curr.isWord) {
                    if (i == s.length()) return true;
                    if (!visited.contains(i)) queue.add(i); // there was a word before i, so try to start from i next time
                }

                if (i == s.length()) break;

                var letter = s.charAt(i);
                if (curr.children.containsKey(letter)) {
                    curr = curr.children.get(letter);
                } else break;
            }
        }

        return false;
    }
}