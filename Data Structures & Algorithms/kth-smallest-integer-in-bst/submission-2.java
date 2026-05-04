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

/*

left
print
right
*/

class Solution {

    int ans = -1;

    int k = 0;

    void dfs(TreeNode node) {
        if (node == null || k == 0) return;
        dfs(node.left);
        
        k--;
        if (k == 0) {
            ans = node.val;
            return;
        }

        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
}
