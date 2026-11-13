/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    // original -> copy
    Map<Node, Node> mapToCopy = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (mapToCopy.containsKey(node)) return mapToCopy.get(node);

        var copy = new Node(node.val);
        mapToCopy.put(node, copy);

        for (var next : node.neighbors) {
            copy.neighbors.add(cloneGraph(next));
        }

        return copy;
    }
}