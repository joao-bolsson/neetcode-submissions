class WordDictionary {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        var curr = root;

        for (var l : word.toCharArray()) {
            if (!curr.children.containsKey(l)) curr.children.put(l, new Node());
            curr = curr.children.get(l);
        }
        curr.isWord = true;
    }

    boolean search(Node node, String word) {
        var curr = node;

        for (var i = 0; i < word.length(); i++) {
            var l = word.charAt(i);
            if (l == '.') {
                for (var child : curr.children.values()) {
                    if (search(child, word.substring(i+1))) return true;
                }
                return false;
            }
            if (!curr.children.containsKey(l)) return false;
            curr = curr.children.get(l);
        }
        return curr.isWord;
    }

    public boolean search(String word) {
        return search(root, word);
    }
}
