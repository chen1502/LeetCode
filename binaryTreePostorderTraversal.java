/**
 * Given a binary tree, return the postorder traversal of its nodes' values
 */
 
// Trivial recursive solution
public class Solution {
    private ArrayList<Integer> list;
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        go(root);
        return list;
    }
    
    private void go(TreeNode root) {
        if (root == null) return;
        go(root.left);
        go(root.right);
        list.add(root.val);
    }
}






// Iterative with stack
public class Solution {

}
