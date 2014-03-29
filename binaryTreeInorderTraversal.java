/**
 * Given a binary tree, return the inorder traversal of its node's values
 */
 
 
// Here we give three methods

// The trivial recursive solution
public class Solution {
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        go(root, list);
        return list;
    }
    private void go(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return;
        go(node.left, list);
        list.add(node.val);
        go(node.right, list);
    }
}
