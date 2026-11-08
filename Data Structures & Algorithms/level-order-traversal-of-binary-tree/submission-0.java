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

    public List<List<Integer>> levelOrder(TreeNode root) {
        var res = new ArrayList<List<Integer>>();

        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {

            var size = queue.size();

            var level = new ArrayList<Integer>();
            while (size-- > 0) {
                // visit all from the same level
                var node = queue.pop();

                if (node == null) continue;

                level.add(node.val);

                queue.add(node.left);
                queue.add(node.right);
            }

            if (!level.isEmpty()) res.add(level);
        }
        return res;
    }
}
