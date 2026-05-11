/*

["cats","dog","sand","and","cat"]

      * *
    i
c a t s a n d o g

- dict needs to have a word that starts with s[0] and a word that ends with s[s.length - 1]
*/

class Solution {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        void add(String w) {
            var curr = root;

            for (var l : w.toCharArray()) {
                if (!curr.children.containsKey(l)) curr.children.put(l, new Node());
                curr = curr.children.get(l);
            }
            curr.isWord = true;
        }
    }

    // from start -> all sentences
    Map<Integer, List<String>> memo = new HashMap<>();

    List<String> backtrack(int start, String s, Trie trie, String currW) {
        if (memo.containsKey(start)) return memo.get(start);

        var curr = trie.root;
        for (var j = start; j < s.length(); j++) {
            var l = s.charAt(j);
            if (!curr.children.containsKey(l)) {
                break;
            }

            currW += l;

            curr = curr.children.get(l);
            if (curr.isWord) {
                if (j == s.length() - 1) {
                    memo.computeIfAbsent(start, k -> new ArrayList<String>()).add(currW);
                } else {
                    var res = backtrack(j+1, s, trie, "");
                    for (var next : res) memo.computeIfAbsent(start, k -> new ArrayList<String>()).add(currW + " " + next);
                }
            }
        }
        return memo.getOrDefault(start, List.of());
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        for (var w : wordDict) trie.add(w);

        return backtrack(0, s, trie, "");
    }
}