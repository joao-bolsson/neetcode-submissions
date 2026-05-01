/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    void preOrder(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(node.val + "");
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var list = new ArrayList<String>();

        preOrder(root, list);

        return list.toString();
    }

    int index = 0;

/*
                                        i
[1, 2, null, null, 3, 4, null, null, 5, null, null]
*/

    TreeNode tree(String[] arr) {
        index++;
        
        if (index >= arr.length) return null;
        if (arr[index].equals("null")) return null;

        var root = new TreeNode(Integer.parseInt(arr[index]));

        root.left = tree(arr);
        root.right = tree(arr);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data: " + data);
        var list = data;
        list = list.replaceAll("\\[", "");
        list = list.replaceAll("\\]", "");
        list = list.replaceAll(" ", ""); // clean spaces

        System.out.println("cleaned: " + list);
        var arr = list.split(",");

        index = -1;
        return tree(arr);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));