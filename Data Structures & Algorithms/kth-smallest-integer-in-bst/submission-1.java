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

    Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap

    void dfs(TreeNode node, int k) {
        if (node == null) return;
        dfs(node.left, k);
        
        if (pq.size() < k) {
            pq.add(node.val);
        }        

        dfs(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return pq.poll(); 
    }
}
