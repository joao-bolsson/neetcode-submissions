class PrefixTree {

    Node root = new Node();

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {
        var node = root;

        for (var l : word.toCharArray()) {
            node = node.children.computeIfAbsent(l, k -> new Node());
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        var node = root;

        for (var l : word.toCharArray()) {
            if (!node.children.containsKey(l)) return false;
            node = node.children.get(l);
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        var node = root;

        for (var l : prefix.toCharArray()) {
            if (!node.children.containsKey(l)) return false;
            node = node.children.get(l);
        }
        return true;
    }
}