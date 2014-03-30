/**
 * Given a binary tree, return the preorder traversal of its nodes' values
 */
 
 
// Trivial recursive solution
public class Solution {
    private ArrayList<Integer> list;
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        go(root);
        return list;
    }
    
    private void go(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        go(root.left);
        go(root.right);
    }
}





// Iterative with stack
public class Solution {
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> S = new Stack<TreeNode>();
        TreeNode curr;
        S.add(root);
        while (!S.empty()) {
            curr = S.pop();
            list.add(curr.val);
            if (curr.right != null) S.add(curr.right);
            if (curr.left != null) S.add(curr.left);
        }
        return list;
    }
}





// Iterative without stack, using threaded binary tree
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        TreeNode curr = root;
        while(curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr) temp = temp.right;
                if (temp.right == curr) {
                    temp.right = null;
                    curr = curr.right;
                }
                else {
                    list.add(curr.val);
                    temp.right = curr;
                    curr = curr.left;
                }
            }
            else {
                list.add(curr.val);
                curr = curr.right;
            }
        }
        
        return list;
    }
}
