import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class DFS {
    
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }|
     void dfsStack(TreeNode root) {
            if(root==null){// base case if root is null
                return;
            }
            Stack<TreeNode> stack=new Stack<>();// ctreate a stack
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node=stack.pop();// pop the top node from the stack
                Sysstem.out.println(node.val+" ");// print the value of node
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                   stack.push(node.left);
                }
            }
           }
/*
 * leetCode :543 -google
 * Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
 */

     int diameter=0;      
    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    private int height(TreeNode root){
         if(root==null){
            return 0;
         }
         int leftHeight=height(root.left);
         int rightHeight=height(root.right);
         diameter=Math.max(diameter,leftHeight+ rightHeight+1);
         return Math.max(leftHeight+rightHeight)+1;
    }
    /*226-google
     * Given the root of a binary tree, invert the tree, and return its root.
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);// invert the left subtree
        TreeNode right=invertTree(root.right);// invert the right subtree
        root.left=right;
        root.right=left;
        return root;
        // TreeNode temp= root.left;
        // TreeNode temp1= root.right;
        // root.left=temp1;
        // root.right=temp;
        // invertTree(root.left);
        // invertTree(root.right);
        // return  root;
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left= maxDepth(root.left);// max depth of left subtree
        int right=maxDepth(root.right);// max depth of right subtree
        return Math.max(1+left,1+right);
       // return Math.max( 1+maxDepth(root.left),1+maxDepth(root.right));
    }
    //114-facebook
    public void flatten(TreeNode root) {
        TreeNode current= root;
        while(current!=null){
            if(current.left!=null){
                TreeNode rightMost= current.left;
                while(rightMost.right!=null){
                    rightMost=rightMost.right;
                }
                rightMost.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
        
    }
     public List<Integer> inorderTraversal(TreeNode root) {
        // Iterative Inorder Traversal
        List<Integer> result=new ArrayList<>();        
        Stack<TreeNode> stack=new Stack<>();// create a stack
        TreeNode current=root;// start from root
        while(current!=null || !stack.isEmpty()){
            // go to the leftmost node
            while(current!=null){
                stack.push(current);// push current node to stack
                current=current.left;
            }
            current=stack.pop();// pop the top node from stack
            result.add(current.val);// add the value to result
            current=current.right;
        }

        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> result){
        if(root==null) return ;
        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right,result);
    }

}
