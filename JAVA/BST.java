import org.w3c.dom.Node;

public class BST {
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;

    public BST(){

    }
    public int height(Node node){
        if(node==null){// base case
            return -1;
        }
          return node.height;
    }
    public boolean isEmpty(){
        return  root==null;
    }

    public void display(){
        display(root, "Root Node: ");
    }
    private void  display(Node node,String  details){
        if(node==null){
            return;
        }
        System.out.println(details+node.value);
        display(node.left ,"Left child of"+node.value+": ");
        display(node.right,"Right child of"+node.value+": ");

    }
    public  void insert(int value){
        this.root = insert(root,value);
    }

    private Node insert(Node node ,int value){
        if(node==null){
            node =new Node(value);
            return node;
        }
        if(value < node.value){
           node.left= insert(node.left,value);
        }
        if(value > node.value){
            node.right=insert(node.right,value);
        }
          node.height=Math.max(height(node.left),height(node.right))+1;
          return node;
    }
    // Traversal methods
    public void preOrder(){
        preOrder(root);
    }
    // Pre-order traversal: Root, Left, Right
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
     
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value+" ");
        inOrder(node.right);
    }
    public void  postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
           if(node==null){
             return;
           }
           postOrder(node.left);
           postOrder(node.right);
           System.out.println(node.value+" ");
    }
    // Populate the BST with an array of numbers
    public  void populated(int[] nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }

    public boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return  Math.abs(height(node.left)-height(node.right)) 
        <= 1 && balanced(node.left) && balanced(node.right);
    }
    

}
