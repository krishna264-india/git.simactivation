import java.util.Scanner;
public class BinaryTree {
    private Node root;
    private static class Node{
        int value;
        Node left;
        Node right;
       public  Node(int value){
            this.value=value;
        }
    }
        // Populate the binary tree by taking user input
        public void populate(Scanner scanner){
            System.out.println("Enter a node value : ");
            int value=scanner.nextInt();// get the value from user
            root=new Node(value);// create a new node  with the given value
            populate(scanner,root);// call the recursive method to populate the tree
        }
        private void populate(Scanner scanner,Node node){
            System.out.println("Enter left  child of node "+node.value+":");
            boolean left=scanner.nextBoolean();
            if(left){
                System.out.println("Enter left child value :" );
                int value=scanner.nextInt();
                node.left=new Node(value);
                populate(scanner,node.left);

            }

            System.out.println("Enter the  right child of value "+node.value+":");
            boolean right=scanner.nextBoolean();
            if(right){
                System.out.println("Enter right child value: ");
                int value=scanner.nextInt();
                node.right=new Node(value);
                populate(scanner,node.right);        
            }
        }

        public void display(){
            display(this.root," ");
        }
        private void display(Node node ,String indent){
            if(node==null){
                return;
            }
            System.out.println(indent+node.value);
            display(node.left,indent+"\t");
            display(node.right,indent+"\t");
        }

    
}
