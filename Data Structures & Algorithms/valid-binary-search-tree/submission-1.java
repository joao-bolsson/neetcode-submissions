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

    boolean isValid(int leftLimit, TreeNode node, int rightLimit) {
        if (node == null) return true;
        if (leftLimit < node.val && node.val < rightLimit) {
            return isValid(leftLimit, node.left, node.val) 
                && isValid(node.val, node.right, rightLimit);
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }
}
