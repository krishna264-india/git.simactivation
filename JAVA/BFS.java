import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Deque;
import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

/*102-leetcode
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 *  (i.e., from left to right, level by level).
 */
public class BFS {
  
 private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode next;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right,TreeNode next) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.next = next;
      }
  }
/*leetcode 102
 */
    public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();
    if(root==null){
        return result;
        }  
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);// add root to the queue
    while(!queue.isEmpty()){ 
        int levelSize=queue.size();// get the current level size
        List<Integer> level=new ArrayList<>();// create a list to store the current level
        for(int i=0;i<levelSize;i++){// traverse the current size
            TreeNode currentNode=queue.poll();// poll the first node in queue
            level.add(currentNode.val);// add the value of the current node to the level list
            if(currentNode.left!=null){
                queue.offer(currentNode.left);// add left child to the queue
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);// add right child to the queue
            }
        }
        result.add(level);// add the current level to the result
    }
    return result;
}
/*
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result=new ArrayList<>();
    if(root==null){
       return result;
    }
    Queue<TreeNode> queue=new LinkedList<>();// create a queue to store the nodes
    queue.offer(root);
    while(!queue.isEmpty()){
        int levelSize=queue.size();

        for(int i=0;i<levelSize;i++){
              TreeNode currentNode=queue.poll();
              // if it is the last node at the current level
              if(i==levelSize-1){
                  result.add(currentNode.val);
              }
              if(currentNode.left!=null){
                  queue.offer(currentNode.left);
              }
              if(currentNode.right!=null){
                 queue.offer(currentNode.right);
              }
        }
    }
     return result;
}
/*637
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
 * Answers within 10-5 of the actual answer will be accepted.
 * Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
 */
public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> result=new ArrayList<>();
    if(root==null){
        return result;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
         int levelSize=queue.size();
         double sum=0;
         for(int i=0;i<levelSize;i++){
             TreeNode node=queue.poll();
             sum+=node.val;
         if(node.left!=null){
            queue.add(node.left);
         }
         if(node.right!=null){
            queue.add(node.right);
         }
        }
         result.add(sum/levelSize);
    }
       return result;
}
// leetcode 510
    public static TreeNode findSuccessor(TreeNode root, int key){
        if(root ==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentSize=queue.size();
            TreeNode currentNode=queue.poll();
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
            // check if the current node is the key
            if(currentNode.val==key){
                break;
            }
        }
        return queue.peek();
    }
    /*
     * leetcode:103
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
         Deque<TreeNode> deque=new LinkedList<>();
         deque.offer(root);
         boolean isReverse=fasle; // default is false
         while(!deque.isEmpty()){ // level order traverasl
            int levelSize=deque.size();// get the current level size
            List<Integer> level=new ArrayList<>(levelSize);// create a list to store the current level
            for(int i=0;i<levelSize;i++){// traverse the current size
                if(!isReverse){// if not reverse ,add the left child first 
                    TreeNode currNode=deque.pollFirst();// poll the firt node in queue
                    level.add(currNode.val);
                    if(currNode.left!=null){
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right!=null){
                        deque.addLast(currNode.right);
                    }
                }else{
                    TreeNode currNode=deque.pollLast();// poll the last node in queue
                    level.add(currNode.val);
                    if(currNode.right!=null){
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left!=null){
                        deque.addFirst(currNode.left);
                    }
                }  
            }
            isReverse=!isReverse;// switch the direction of the level order traversal
            result.add(level); // add the current level to the result
         }
         return result;
    }
    /*
     * 107. Binary Tree Level Order Traversal II
     * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
     *  (i.e., from left to right, level by level from leaf to root).
     * 
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> level=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode=queue.poll();// poll the first node in queue
                level.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
             result.add(0,level);
        }
        return result;
    }
    /*
     * 116. Populating Next Right Pointers in Each Node
     * You are given a perfect binary tree where all leaves are on the same level, 
     * and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
     */

    public static  Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){// if left child is not null
            root.left.next=root.right;
        }
        if(root.right!=null && root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        //Exlain the algorithm
        //1. traverse the tree to find two nodes 
        //2.check if they are cousin
        if(root==null){
            return false;
        }
        if(root.left!=null && root.right!=null &&(root.left.val==x && root.right.val==y)){
            return false;
        }
        if(root.left!=null && root.left.val==x){
            return isCousins( root.left,x,y);
        }
        if(root.right!=null && root.right.val==y){
            return isCousins(root.right,x,y);
        }
        // if(root.left!=null && root.right.val==x){
        //     return isCousins( root.left,x,y);
        // }
        // if(root.left!=null && root.left.val==y){
        //     return isCousins( root.left,x,y);
        // }
        return isCousins(root.left,x,y) || isCousins(root.right,x,y);
    }
    /* * 101. Symmetric Tree
     * Given the root of a binary tree, 
    check whether it is a mirror of itself (i.e., symmetric around its center).
     */

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        return (t1.val==t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
   public static void main(String[] args){

    TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.left = new TreeNode(8);
        root.right.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.right.right.left=new TreeNode(24);
    //  List<Double> averages=averageOfLevels(root);
    //  List<Integer> order=levelOrder(root);
      List<List<Integer>> zigzag=zigzagLevelOrder(root);


      System.out.println(zigzag);
   }
}
