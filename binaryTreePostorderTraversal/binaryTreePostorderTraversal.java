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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         if (root == null) return list;
         
         Stack<TreeNode> S = new Stack<TreeNode>();
         TreeNode curr = root;
         TreeNode temp, prev = root;
         S.add(root);
         while(!S.empty()) {
              temp = S.peek();
              if ( (temp.left == null && temp.right == null) || 
                   temp.left == prev || temp.right == prev) {
                   prev = temp;
                   list.add(temp.val);
                   S.pop();
              }
              else {
                   if (temp.right != null) S.add(temp.right);
                   if (temp.left != null) S.add(temp.left);
              }
         }
         return list;
    }
}




// Iterative without stack, using threaded binary tree
// postorder is harder than inorder or preorder
// but if we switch left and right child
// preorder is reversed postorder

public class Solution {
     // If we switch left and right, it is preorder traversal, no need to reverse list
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        TreeNode curr = root;
        while(curr != null) {
            if (curr.right != null) {
                TreeNode temp = curr.right;
                while(temp.left != null && temp.left != curr) temp = temp.left;
                if (temp.left == curr) {
                    temp.left = null;
                    curr = curr.left;
                }
                else {
                    list.add(curr.val);
                    temp.left = curr;
                    curr = curr.right;
                }
            }
            else {
                list.add(curr.val);
                curr = curr.left;
            }
        }
        
        return reverse(list);
     }
     
     private ArrayList<Integer> reverse(ArrayList<Integer> list) {
         int n = list.size();
         ArrayList<Integer> newList = new ArrayList<Integer>(n);
         for (int i = n - 1; i >= 0; i--) newList.add(list.get(i));
         return newList;
     }
}



// if in the above method we don't want to switch left and right,
// then we have to reverse the list piecewise
public class Solution {
    private ArrayList<Integer> list;
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        if (root == null) return list;
        
        TreeNode curr = new TreeNode(0);
        curr.left = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    go(curr.left);
                    curr = curr.right;
                }
            }
            else {
                curr = curr.right;
            }
        }
        
        return list;
     }
     
     // go over a piece of the tree and add the values in list reversely
     private void go(TreeNode node) {
         ArrayList<Integer> t = new ArrayList<Integer>();
         while (node != null) {
             t.add(node.val);
             node = node.right;
         }
         for (int i = t.size() - 1; i >= 0; i--) list.add(t.get(i));
     }
     
}
