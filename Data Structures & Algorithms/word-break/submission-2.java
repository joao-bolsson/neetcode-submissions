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

    Map<Integer, Boolean> memo = new HashMap<>();

    boolean backtrack(int start, String s, Trie trie) {
        if (memo.containsKey(start)) return memo.get(start);

        var curr = trie.root;
        for (var j = start; j < s.length(); j++) {
            var l = s.charAt(j);
            if (!curr.children.containsKey(l)) {
                memo.put(start, false);
                break;
            } 

            curr = curr.children.get(l);
            if (curr.isWord) {
                if (j == s.length() - 1) {
                    memo.put(start, true);
                    break;
                }
                if (backtrack(j+1, s, trie)) {
                    memo.put(start, true);
                    break;
                }
            }
        }
        return memo.getOrDefault(start, false);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        for (var w : wordDict) trie.add(w);

        return backtrack(0, s, trie);
    }
}