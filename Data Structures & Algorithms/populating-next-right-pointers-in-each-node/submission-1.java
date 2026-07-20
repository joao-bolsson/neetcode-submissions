/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {

    void preOrder(Node node, Node uncle) {
        if (node == null || node.left == null) return;
        node.left.next = node.right;
        if (uncle != null) node.right.next = uncle.left;

        preOrder(node.left, node.right);
        preOrder(node.right, uncle != null ? uncle.left : null);
    }

    public Node connect(Node root) {
        preOrder(root, null);

        return root;
    }
}