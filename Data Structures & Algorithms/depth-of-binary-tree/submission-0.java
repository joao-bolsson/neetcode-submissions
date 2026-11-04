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

    int depth(TreeNode node) {
        if (node == null) return 0;

        int dLeft = depth(node.left) + 1;
        int dRight = depth(node.right) + 1;

        return Math.max(dLeft, dRight);
    }

    public int maxDepth(TreeNode root) {
        
        return depth(root);
    }
}
