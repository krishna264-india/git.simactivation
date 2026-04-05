public class SingleLL {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
   public ListNode reverseBetween(ListNode head, int left, int right) {
      if(head==null) return null;
      ListNode dummy=new ListNode(0);
      dummy.next=head;
      ListNode prev=dummy;
      // move prev to the node before left
      for(int i=0;i<left-1;i++){
        prev=prev.next;// move prev to the left-1 th node
      }  
      ListNode curr=prev.next;
      // reverse the sublist from left to right
      for(int i=0;i<right-left;i++){
        ListNode temp=curr.next;
        curr.next=temp.next;
        temp.next=prev.next;
        prev.next=temp;
      }
      return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode nextTemp=current.next;
            current.next=prev;
            prev=current;
            current=nextTemp;
        }
        return prev;
    }
}
