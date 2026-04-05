import org.w3c.dom.Node;

public class LL {

    private Node head;

    class Node{
         int val;
         Node next;
         public Node(int val){
             this.val=val;
             this.next=null;
         }

    }
     static void forWardTravesal(Node head){
        Node temp=head;
        while(temp!=null){
           System.out.print(temp.val+" ");
           temp=temp.next;
        }
        System.out.println();
    }
    static boolean searchIndex(Node head,int key){
        Node temp=head;

        while(temp!=null){
            if(tmep.val==key){
              return true;

              temp=temp.next;
            }
            return false;
        }
    }
    public void insertAtFirst(int val){
        Node newNode=new Npde(val);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }
    public void insertAtLast(int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    public static Node insertAtAnyPos(Node head, int val,int pos){
        Node newNode=new Node(val);
        if(pos==0){
            newNode.next=head;
            hrad=newNode;
        }
        if( pos==1){
            Node curr= head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
            return 
        }
        Node node=new Node(val);
        Node temp=head;
        for(int i=0;i<pos;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        return head;
    }

    public Node deleteAtFirst(Node head){
        if(head==null){
            return null;
        }
        Node node=head;
        head=head.next;
        return head;
    }
    public Node deleteAtLast(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            head=null;
            return head;
        }
        Node SLast=head;
        while(SLast.next.next!=null){
            SLast=SLast.next;
        }
        SLast.next=null;
        return head;
    }


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head.next=head.next.next;
                }
                prev.next=head.next;
            }else{
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}

        
    }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    tail.next=list1;
                    list1=list1.next;
                    tail=tail.next;
                }else{
                    tail.next=list2;
                    list2=list2.next;
                    tail=tail.next;
                }
        
    }
              tail.next=(list1!=null)?list1:list2;
        
                     return dummy.next;
}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node
 */
class Solution {
    public ListNode middleNode(ListNode head) {
          ListNode fast=head;
          ListNode slow=head;
          while(fast!=null && fast.next!=null){
                 fast=fast.next.next;
                 slow=slow.next;
          }
          return slow;

        
    }
}

   public  static void main(String[] args){
        LL list=new LL();
        Node head=list.new Node(1);
        Node node2=list.new Node(2);
        Node node3=list.new Node(3);
        Node node4=list.new Node(4);
         head.next=node2;
         node2.next=node3;
         node3.next=node4;
         System.out.println("forword");
         forWardTravesal(head);
         searchIndex(head);

    }


    
    
}
