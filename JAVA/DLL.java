import org.w3c.dom.Node;

public class DLL {

    private Node head;

    public int add(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;

    }
    public void addLast(int value){
        Node node=new Node(value);
        node.last=head;
        node.next=null;
        if(head==null){
            head.prev=null;// head is null
            head=node;// head is node
            return;
        }
         while(last.next!=null){
            last=last.next;
         }
         last.next=node;
         node.prev=last;
    }
    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.val==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
       public void deleteFirst (Node head){
        if(head==null){
            System.out.println("List is empty!,nothing to delete");
            return null;
        }
         if(head.next==null){
            head=null;
            return ;
         }
         head=head.next;
         head.prev=null;
       }
       public void deleteLast(ListNode head){\
        if(head==null){
            System.out.println("List is empty!,nothing to delete");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node node=head;
        while(node.next!=null){
            node=node.next;
        }
         node.prev.next=null;
       }
       public static ListNode deleteAtPos(Node head,int pos){
        if(head==null){
            return head;
        }
         ListNode node=head;
         for(int i=0;node!=null&&i<pos; i++){
            node=node.next;
         }
          if(node==null){// out of bound
            return head;
          }
           if( node.prev!=null){
            node.prev.next=node.next;
           }
           if(node.next!=null){
            node.next.prev=node.prev;
           }
           if(node==head){
            head=node.next;// move head to next
           }
             node=null;// to prevent memory leak
            return head;
       }
       public void deleteNode(ListNode node){
        if(node==null){
            return ;
        }
        node.value=node.next.value;// copy values from next node
        node.next=node.next.next;// skip next node

       }
       public Node reverseList(Node head) {
           Node node=null;
           while(head!=null){
            Node temp= head.next;
            head.next=node;// reverse link
            node=head;//move to next node
            head=temp;
           }
           return node;
       }
       public static void forWordTraversal(Node head){
        ListNode node=head;
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
       }
       public static void backwardTraversal(Node tail){
        Node curr=tail;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.prev;
        }
        System.out.println();
       }
       public static void main(String[] args){
        DLL dll=new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);
       }
      

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
    
         }
         public Node(int val,Node next,Node prev){
                this.val = val;
                this.next = next;
                this.prev = prev;
         }
    }
       
     
}
