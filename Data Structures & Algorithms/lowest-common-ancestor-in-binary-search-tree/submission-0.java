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

    String sideOf(TreeNode root, TreeNode p) {
        return p.val < root.val ? "left" : "right";
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;

        var pSide = sideOf(root, p);
        var qSide = sideOf(root, q);

        if (!pSide.equals(qSide)) return root; // nodes in different sides: ancestor is root

        var nextRoot = pSide.equals("left") ? root.left : root.right;

        return lowestCommonAncestor(nextRoot, p, q);
    }
}
