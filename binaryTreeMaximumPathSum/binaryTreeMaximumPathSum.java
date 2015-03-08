/**
 * Given a binary tree, find the maximum path sum
 * The path may start and end at any node in the tree
 * The path must contain at least one node
 */
 
// Recursive linear time
public class Solution {
    private int record;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        record = root.val;
        helper(root);
        return record;
    }
    
    // return maximum sum of a path from root to one of its descendant,
    // return 0 if no sum is positive
    // meanwhile, update record by max path sum
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int lv = helper(root.left);
        int rv = helper(root.right);
        record = Math.max(record, root.val + lv + rv);
        int ans = root.val + Math.max(lv, rv);
        return Math.max(ans, 0);
    }
}
