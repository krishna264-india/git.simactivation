class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class LLInterview {
     public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;

        // dummy node to help with edge cases
        ListNode dummy=new ListNode(0);
        ListNode current=head;
        while(current!=null){
            // find the right place to insert current node
            ListNode prev=dummy;
            // find the right place to insert current node
            while(prev.next!=null && prev.next.val<current.val){
                prev=prev.next;
            }
            // insert current between prev and prev.next
            ListNode nextTemp=current.next;
            current.next=prev.next;
            prev.next=current;
            current=nextTemp;
        }
        return dummy.next;
        
    }
}

