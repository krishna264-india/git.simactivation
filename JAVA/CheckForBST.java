import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
public class CheckForBST {
    public boolean isBST(Node root) {
        // Initialize min and max values
         int min=Integer.MIN_VALUE;
         int max=Integer.MAX_VALUE;
         return isBSTUtil(root,min,max);
    }
    private boolean isBSTUtil(Node node,int min, int max){
        // Base case: an empty node is a BST
        if(node==null) return true;
        // Check if the current node's data is within the valid range
        if(node.data<min || node.data>max){
            return false;
        }
        // Recursively check the left and right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        leftViewUtil(root,result,0);
        return result;
    }
    private void leftViewUtil(Node node,ArrayList<Integer> result,int level){
        if(node==null){
            return;
        }
        // If this is the first node of its level
        if(level==result.size()){
            result.add(node.data);
        }
        // Recur for left and right subtrees
        leftViewUtil(node.left,result,level+1);
        leftViewUtil(node.right,result,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        // Call the utility function to fill the result list
        rightSideViewUtil(root,result,0);
        return result;
    }
    private void rightSideViewUtil(TreeNode node,List<Integer> result,int level){
        if(node==null){
            return;
        }
        // If this is the first node of its level
        if(level==result.size()){
            result.add(node.data);
        }
        // Recur for right and left subtrees
        rightSideViewUtil(node.right, result, level+1);
        rightSideViewUtil(node.left, result, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        levelOrderUtil(root,result,0);
        return result;
    }
    private void levelOrderUtil(TreeNode node,List<List<Integer>> result,int level){
        if(node==null) return ;
        // If this is the first node of its level
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        // Add the current node's value to its level list
        result.get(level).add(node.data);
        // Recur for left and right subtrees
        levelOrderUtil(node.left, result, level+1);
        levelOrderUtil(node.right, result, level+1);
    }
}

