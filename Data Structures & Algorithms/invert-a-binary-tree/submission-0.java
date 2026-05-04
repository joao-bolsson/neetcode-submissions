/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    void invert(TreeNode curr) {
        if (curr == null) return;

        var tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;

        invert(curr.left);
        invert(curr.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
