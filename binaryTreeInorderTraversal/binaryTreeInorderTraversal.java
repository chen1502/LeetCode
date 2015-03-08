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






// Iterative with a stack
public class Solution {
 
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         Stack<TreeNode> S = new Stack<TreeNode>();
         TreeNode curr = root;
         while(true) {
              if(curr != null) {
                   S.push(curr);
                   curr = curr.left;
              }
              else if (!S.empty()) {
                   curr = S.pop();
                   list.add(curr.val);
                   curr = curr.right;
              }
              else break;
         }
         return list;
    }
}





// Iterative without a stack. Threaded binary tree
public class Solution {
 
     public ArrayList<Integer> inorderTraversal(TreeNode root) {
          ArrayList<Integer> list = new ArrayList<Integer>();
          TreeNode curr = root;
          while(curr != null) {
               if (curr.left != null) {
                    TreeNode temp = curr.left;
                    while(temp.right != null && temp.right != curr) temp = temp.right;
                    if (temp.right == null) {
                         temp.right = curr;
                         curr = curr.left;
                    }
                    else {
                         temp.right = null;
                         list.add(curr.val);
                         curr = curr.right;
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
