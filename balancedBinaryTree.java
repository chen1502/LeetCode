/**
 * Given a binary tree, determine if it is height-balanced
 * Here height-balanced means the depth of the two subtrees of every node never differ by more than 1
 */
 
// Recursive solution, linear complexity
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanceHelper(root) >= 0;
    }
    
    // returns the height if is balanced, -1 otherwise
    private int balanceHelper(TreeNode root) {
        if (root == null) return 0;
        int a = balanceHelper(root.left);
        int b = balanceHelper(root.right);
        if(a < 0 || b < 0 || Math.abs(a - b) > 1) return -1;
        return Math.max(a, b) + 1;
    }
}
