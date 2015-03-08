/**
 * Given a binary tree, return the level order traversal of its node's values
 * i.e, from left to right, level by level
 */
 
// basically this is BFS, we use a queue to store each level
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode n = queue.poll();
                list.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            ans.add(list);
            queue = q;
        }
        
        return ans;
    }
}
