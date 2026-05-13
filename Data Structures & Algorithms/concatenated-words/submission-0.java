class Solution {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        void add(String word) {
            var curr = root;

            for (var l : word.toCharArray()) {
                if (!curr.children.containsKey(l)) curr.children.put(l, new Node());
                curr = curr.children.get(l);
            }
            curr.isWord = true;
        }
    }

    Map<String, Boolean> memo = new HashMap<>();

    boolean dfs(int i, Trie trie, String w) {
        if (i == w.length()) return true;

        var subWord = w.substring(i);
        if (memo.containsKey(subWord)) return memo.get(subWord);

        var ans = false;
        var curr = trie.root;
        for (var j = i; j < w.length(); j++) {
            var l = w.charAt(j);
            if (curr.children.containsKey(l)) {
                curr = curr.children.get(l);
                
                if (curr.isWord) {
                    ans = ans || dfs(j+1, trie, w);
                }
            } else {
                break;
            }
        }
        memo.put(subWord, ans);
        return ans;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {        
        var trie = new Trie();
        for (var w : words) trie.add(w);

        var res = new ArrayList<String>();
        for (var w : words) {
            var curr = trie.root;

            // go to the final node char that is a word
            var i = 0;
            var ans = false;
            for (; i < w.length() - 1; i++) {
                var l = w.charAt(i);
                curr = curr.children.get(l);
                if (curr.isWord) {
                    ans = ans || dfs(i+1, trie, w);
                }
            }

            if (ans) res.add(w);
        }
        return res;
    }
}