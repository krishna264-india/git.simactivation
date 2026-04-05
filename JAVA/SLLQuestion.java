import org.w3c.dom.Node;

private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
public class SLLQuestion {

    public ListNode middleNode(ListNode head) {
        // Find the middle node using slow/fast pointer approach
        ListNode slow=head, fast=head;
        // move slow by 1 and fast by 2
        while(fast!=null && fast.next!=null){
            slow=slow.next;// move slow by 1
            fast=fast.next.next;// move fast by 2
        }
        return slow;// when fast reaches the end, slow will be at the middle
    }
    public ListNode reverseList(ListNode head) {

        // Reverse the linked list iteratively
        ListNode prev=null;
        ListNode current=head;
        // Traverse the list and reverse the links
        while(current!=null){
            ListNode nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }
        return prev;// new head of the reversed list
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Remove the nth node from the end of the list
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy, second=dummy;
            head=nextNode;
        } 
        return prev;// new head of the reversed list

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Remove the nth node from the end of the list
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy, second=dummy;
        // Move first n+1 steps ahead
        for(int i=0;i<=n;i++){
            first=first.next;
        }
        // Move both first and second until first reaches the end
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        // Now second is at the node before the one we want to remove
        second.next=second.next.next;// remove the nth node from end
        return dummy.next;// return the head of the modified list
    }
    public static void removeLoop(ListNode head) {
        // Detect and remove loop in the linked list using Floyd's Cycle-Finding Algorithm
        if(head==null || head.next==null){
            return;// no loop if list is empty or has only one node
        }
        ListNode slow=head, fast=head;
        // Detect loop
        while(fast!=null && fast.next!=null){
            slow=slow.next;// move slow by 1
            fast=fast.next.next;// move fast by 2
            if(slow==fast){
                break;// loop detected
            }
        }
        // If loop exists, remove it
        if(slow==fast){
            slow=head;
            // Find the start of the loop
            while(slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            // Remove the loop
            fast.next=null;
        }
    }
    public ListNode sortList(ListNode head) {
        
        // Sort the linked list using merge sort
        if(head==null || head.next==null){
            return head;// base case: list is empty or has one node
        }
        // Split the list into two halves
        ListNode mid=getMid(head);
        ListNode left=sortList(head);// sort the left half
        ListNode right=sortList(head);// sort the right half
        return merge(left,right);// merge the sorted halves
    }
    public ListNode getMid(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            elase{
                tail.next=l2;
                l2=l2.next;
            }
        }
        if(l1!=null) tail.next=l1;
        if(l2!=null) tail.next=l2;
        return dummy.next;
    }
     public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
       ListNode temp=head;
       int count=0;
       while(temp!=null){
        count++;// count the number of nodes in the list
        temp=temp.next;// move to the next node
       }
       ListNode prev=dummy;
         while(count>=k){// while there are at least k nodes remaining
          ListNode current=prev.next;
          ListNode next=null;
          ListNode tail=current;
          // Reverse k nodes
          for(int i=0;i<k;i++){
                next=current.next;
                current.next=prev.next;
                prev.next=current;
                current=next;
          }
          tail.next=current;
          prev=tail;
          count-=k;
         }
         return dummy.next;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current=head;
        while(current!=null && current.next!=null){
            int gcd=getGCD(current.val,current.next.val);// calculate GCD of current and next node values
            ListNode newNode=new ListNode(gcd);// create a new node with the GCD
            newNode.next=current.next;// link the new node to the next node
            current.next=newNode;// link the current node to the new node
            current=newNode.next;// move to the next node
        }
        return head;
    }
    private int getGCD(int a,int b){
        if(b==0) return a;
        return getGCD(b,a%b);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Find the intersection node of two linked lists
        if(headA==null || headB==null){
            return null;// no intersection if either list is empty
        }
        ListNode a=headA, b=headB;
        // Traverse both lists and switch heads when reaching the end
        while(a!=b){
            a=(a==null)?headB:a.next;// switch to headB after reaching the end of list A
            b=(b==null)?headA:b.next;// switch to headA after reaching the end of list B
        }
        return a;// either the intersection node or null if no intersection exists
    }
    
}
