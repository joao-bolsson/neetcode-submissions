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
               e
                  s
pre [3,9,20,15,7]

                  m
in  [9,3,15,20,7]

    
      3
    9   20
      15  7

            e
          s
preorder=[1,2,3,4]
   
            m
inorder= [2,1,3,4]

    1

*/

class Solution {

    Map<Integer, Integer> mapIn = new HashMap<>();

    int preIndex = 0;

    public TreeNode tree(int[] preorder, int[] inorder, int start, int end) {
        if (end < start) return null;   
        var root = new TreeNode(preorder[preIndex++]);

        var mid = mapIn.get(root.val);

        root.left = tree(preorder, inorder, start, mid - 1);
        root.right = tree(preorder, inorder, mid + 1, end);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (var i = 0; i < inorder.length; i++) mapIn.put(inorder[i], i);

        return tree(preorder, inorder, 0, inorder.length - 1);
    }
}
