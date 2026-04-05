import org.w3c.dom.Node;
private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        
    }

public class SLL {

    private Node head;

    void insertAtBeginning(int data){
        Node newNode=new Node(data);
        // if(head==null){
        //     head=newNode;
        //     return;
        // }
        // newNode.next=head;
        // head=newNode;
        if(head!=null){
            newNode.next=head;
            head=newNode;
        }else{
            head=newNode;
            newNode.next=null;
        }
    }
    void insertAtEnd(int data){
        Node tail=new Node(data);
        if(head==null){
            head=tail;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=tail;// link the last node to the new node
        tail.next=null;// make sure the new tail points to null
    }
    void insertAtAnyPosition(int data,int position){
        Node newNode=new Node(data);
        if(position==0){
            insertAtBeginning(data);
            return;
        }
        Node current=head;
        // traverse to the position
        for(int i=0;current.next!=null && i<position-1;i++){
            current=current.next;
        }
        // if we reached the end, insert at the end
        if(current.next==null){
            insertAtEnd(data);
        }else{
            newNode.next=current.next;// link newNode to the next node
            current.next=newNode;
        }
        System.out.println("Inserted " + data + " at position " + position);
    }
    void deleteAtBeginning(){
        // check if list is empty
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        // move head to the next node
        head=head.next;
        System.out.println("Deleted node at beginning");
    }
    void deleteByValue(int value){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.data==value){// value is at head
            head=head.next;// delete head
            System.out.println("Deleted node with value " + value);
            return;
        }
        Node current=head;
        // traverse to the node before the node to be deleted
        while(current.next!=null && current.next.data!=value){
            current=current.next;
        }
        // if we reached the end, value not found
        if(current.next==null){
            current.next=null;

        }else{
            current.next=current.next.next;
        }
    }
    void deleteAtEnd(){
        if(head==null) return;
        if(head.next==null){// only one node
            head=null;// now head is null
            return;
        }
        Node current=head;
        while(current.next!=null && current.next.next!=null){// traverse to the second last node
            current=current.next;// move to next node
        }
        current.next=null;// remove reference to last node
    }
    void deleteAtPosition(int position){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        // delete head
        if(position==0){
            head=head.next;
            System.out.println("Deleted node at position " + position);
            return;
        }
        Node current=head;
        for(int i=0;current.next!=null && i<position-1;i++){
            current=current.next;
        }
        if(current.next==null){// position is out of bounds
            System.out.println("Position " + position + " not found in the list");
        }else{
            current.next=current.next.next;// bypass the node to be deleted
            System.out.println("Deleted node at position " + position);
        }
    }
    boolean search(int value){
        Node current=head;
        while(current!=null){
            if(current.data==value) return true;
            current=current.next;
        }
        return false;
    }
     void display(){
        Node current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public static void main(String[] args) {
        SLL list=new SLL();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtAnyPosition(25,2);
        list.display();
        System.out.println("After Deletion:");
        list.deleteAtBeginning();
        list.deleteByValue(25);
        list.deleteAtEnd();
        list.deleteAtPosition(1);
        list.display();
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 100: " + list.search(100));
    }
}