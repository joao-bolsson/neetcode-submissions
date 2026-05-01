class Solution {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        void add(String s) {
            var curr = root;

            for (var l : s.toCharArray()) {
                if (!curr.children.containsKey(l)) curr.children.put(l, new Node());
                curr = curr.children.get(l);
            }
            curr.isWord = true;
        }
    }

/*

wordDict = ["cat","cats","and","sand","dog"]
    
    * *     *       *
                    i
s
c a t s a n d d o g

*/

    record Tuple(int start, String currPhrase) {}

    public List<String> wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        for (var w : wordDict) trie.add(w);

        var queue = new LinkedList<Tuple>();
        queue.add(new Tuple(0, "")); // candidates to start a word

        var res = new ArrayList<String>();

        while (!queue.isEmpty()) {
            var tuple = queue.pop();

            var start = tuple.start;
            var phrase = tuple.currPhrase;

            var curr = trie.root;
            for (var i = start; i <= s.length(); i++) {
                if (curr.isWord) {
                    if (i == s.length()) {
                        res.add(phrase);
                        break;
                    }
                    queue.add(new Tuple(i, phrase + " ")); 
                }

                if (i == s.length()) break;

                var letter = s.charAt(i);
                if (!curr.children.containsKey(letter)) break;

                phrase += letter;

                curr = curr.children.get(letter);
            }
        }
        return res;
    }

}