import java.util.PriorityQueue;

import org.w3c.dom.Node;

import LLC.ListNode;

public class DLLInterviewQuestions {
    public static void main(String[] args){
        //1.how to reverse a linked list
        ListNode head =new ListNode(1);
        head.next=new ListNode(2);

    }

/*
 * hash cycle is using Floyd's Cycle-Finding Algorithm
 * also known as the Tortoise and Hare algorithm
 * slow as(tortoise) and fast as (hare) algorithgam
 * Both pointers start at the head of the list.
The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
If there is no cycle, the fast pointer will eventually reach the end of the list (i.e., fast == null or fast.next == null).
If there is a cycle, the fast pointer will eventually meet the slow pointer inside the cycle.
 */
    public static boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        // Traverse the list with two pointers: slow (1 step) and fast (2 steps)
        while (fast!=null && fast.next!=null){ 
            fast=fast.next.next;// Move fast by 2 steps
            slow=slow.next;// move slow by 1 step
             // If slow and fast pointers meet, there is a cyclez
            if(slow==fast){
                return true;

            }
        }
        return false;

      }
      
      public static int middleNode(ListNode head){
        if(head==null){
            return 0;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;// move slow by 1 step
            fast=fast.next.next;// fast move by 2 steps
            // if(fast==slow){
            //     return slow.val;
            // }
        }
        return slow.val;// return the value of the middle node

      }
      public int lengthOfLastWeeks(ListNode head){
        if(head==null){
            return 0;
        }
        ListNode current=head;// start at the head of the list
        int totalLength =0;
        while(current!=null){
            totalLength++;
            current=current.next;// move to the next node
        }
        // Step 2: Calculate the length of the last week (7 nodes per week)
        int cycleLength= totalLength %7;

        return cycleLength==0 ? 7 : cycleLength;
      }
      public int lengthCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null &&  fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){// if the two pointers meet, thers is a cycle
                // Cycle detected, now find the length of the cycle
                int cycleLength=0;
                ListNode current=slow.next;
                
                while(current!=null){
                    // Count the number of nodes in the cycle
                    cycleLength++;
                    current=current.next;
                }
                return cycleLength;
            }
        return 0;
      }
      public int deleteCycle(ListNode head){
        ListNode fast=head;// fast pointer
        ListNode slow=head;// slow pointer
        // Step 1: Detect if there's a cycle using Floyd's Cycle-Finding Algorithm
        while(fast!=null &&  fast.next!=null){
            fast=fast.next.next;// fast is moving 2 times
            slow=slow.next;// slow is moving 1 time
            if(fast==slow){// if the two pointers meet ,there is cycle
                ListNode start=slow;
                ListNode end=fast;
                
                int length=lengthCycle(head);
                // step 2: find the start of the cycle
                while( start!=end){
                    start=start.next;
                    end=end.next;
                }
                return start.val;
            }

        }
         return 0;

      }
      public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
                current= current.next;
            }else{ 
                current.next=list2;
                list2=list2.next;
                current=current.next;
            }
        }
         if(list1!=null){
            current.next=list1;
         }
          if(list2!=null){
            current.next=list2;
          }
                    //current.next=(list1!=null)?list1:list2;
                    return dummy.next;

         }

      public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(0);// dummy node
        dummy.next=head;// dummy node point to head
        ListNode fast=dummy;
        ListNode slow=dummy;
         // Move fast pointer n steps ahead
        for(int i=1;i<=n+1;i++){
            fast=fast.next;
        }
        // Move both fast and slow pointers together until fast reaches the end
          while(fast!=null){
            fast=fast.next;
            slow=slow.next;
          }
          // Remove the nth node from the end
          slow.next=slow.next.next;
          return dummy.next;
        }
        public void deleteNode(ListNode node) {
            node.val=node.next.val;// copy the value of next node to current node
            node.next=node.next.next;//skip the next node
        }
        public boolean isPalindrome(ListNode head) {
            if(head==null) return true;
            ListNode slow=head;
            ListNode fast=head;
            // find the middle of the linked list
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;// move slow pointer by 1 step
                fast=fast.next.next;// move fast pointer by 2 step
            }
            // Step 2: Reverse the second half of the list
            ListNode secondHalf=reverseList(slow);
            // Step 3: Compare the first half and the reversed second half
            ListNode firstHalf=head;
            while(firstHalf!=null && secondHalf!=null){
                if(firstHalf.val!=secondHalf.val){
                    return false;
                }
                 firstHalf=firstHalf.next;
                 secondHalf=secondHalf.next;
            }
            return true;        
        }
        public ListNode reverseList(ListNode head){
            ListNode node=null;
            while(head!=null){
                ListNode temp= head.next;
                head.next=node;
                node=head;
                head=temp;
            }
            return node;
        }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy=new ListNode(0);
            ListNode current=dummy;
            int carry=0;// carry from previuos addition
            // Traverse both lists until both are exhausted
            while(l1!=null || l2!=null || carry!=0){
                int sum=carry;
                if(l1!=null){
                    sum+=l1.val;
                    l1=l1.next;
                }
                if(l2!=null){
                    sum+=l2.val;
                    l2=l2.next;
                }
                // Create a new node with the sum of the current nodes and the carry
                sum=sum/10;
                int digit= sum%10;
                current.next=new ListNode(digit);
                current=current.next;
            }
//                 int x=(l1!=null)?l1.val:0;
//                 int y=(l2!=null)?l2.val:0;
//                 int sum=x+y+carry;
//                 carry=sum/10;
//                 current.next=new ListNode(sum%10);
//                 current=current.next;// Move the current pointer
//  // Move to the next nodes in the input lists (if available)
//                 if (l1 != null) l1 = l1.next;
//                 if (l2 != null) l2 = l2.next;
//             }
            return dummy.next;
        
        }
        public ListNode swapPairs(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode current=dummy;  
            // Iterate through the list while there are at least two nodes left to swap
            while(current.next!=null && current.next.next!=null){
                 // Assign pointers to the first and second nodes in the pair
                ListNode first=current.next;
                ListNode second=current.next.next;

                first.next= second.next;
                second.next=first;
                current.next= second;
                
                current=first;
            }

                return dummy.next;
        }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB==null) return null;
            ListNode p1=headA;
            ListNode p2=headB;
            while(p1!=p2){
                p1=p1!=null?p1.next:headB;// Move p1 to the end of list B if p1 is not null
                p2=p2!=null?p2.next:headA;
                // if(p1!=null){
                //     p1=p1.next;
                //     else{
                //         p1=headB;
                //     }
                // }
                // if(p2!=null){
                //     p2=p2.next;
                //     else{
                //         p2=headA;
                //     }
                // }
            }
            return p1;
        
        }
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode prev=dummy;
            while(head!=null && head.next!=null){
                if(head.val=head.next.val){
                    while(head.next!=null && head.val==head.next.val){
                        head.next=head.next.next;
                    }
                    prev.next=head.next;
                }
                else{
                    prev=head;
                }
                head=head.next;
            }
            return dummy.next;
        }

        public void printList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
// 23. Merge k Sorted Lists
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);
           // pq.offer(lists[0]);
            // iterate through all the lists and add the head of each list to the priority queue
            for(ListNode node: lists){ 
                if(node!=null){
                    pq.offer(node);
                    // pq.add(node);
                }
            }
            ListNode dummy=new ListNode(0);
            ListNode curr=dummy;
            while(!pq.isEmpty()){
                ListNode node=pq.poll();// remove the smallest node from the priority queue
                curr.next=node;
                curr=curr.next;
                if(node.next!=null){
                    pq.offer(node.next);
                }
            }
            return dummy.next;
        }
   private class ListNode {
        int val;
        ListNode next;
    
        public ListNode() {
        }
    
        ListNode(int x) {
            val = x;
            next = null;
        }
}
}
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy=new ListNode(0);
    ```java
// 1. Reverse a Linked List
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

// 2. Detect Cycle in a Linked List
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}

// 3. Find Middle Node of a Linked List
public ListNode middleNode(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// 4. Length of Last Week
public int lengthOfLastWeek(ListNode head) {
    if (head == null) {
        return 0;
    }
    int totalLength = 0;
    ListNode current = head;
    while (current != null) {
        totalLength++;
        current = current.next;
    }
    int cycleLength = totalLength % 7;
    return cycleLength == 0 ? 7 : cycleLength;
}

// 5. Length of Cycle
public int lengthCycle(ListNode head) {
    if (head == null) {
        return 0;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode current = slow.next;
            int cycleLength = 1;
            while (current != slow) {
                cycleLength++;
                current = current.next;
            }
            return cycleLength;
        }
    }
    return 0;
}

// 6. Delete Cycle
public ListNode deleteCycle(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode start = slow;
            ListNode end = fast;
            int length = lengthCycle(head);
            while (start != end) {
                start = start.next;
                end = end.next;
            }
            return start;
        }
    }
    return null;
}

// 7. Merge Two Lists
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    if (list1 != null) {
        current.next = list1;
    } else if (list2 != null) {
        current.next = list2;
    }
    return dummy.next;
}

// 8. Remove Nth Node From End
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 1; i <= n + 1; i++) {
        fast = fast.next;
    }
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}

// 9. Delete Node
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

// 10. Palindrome
public boolean isPalindrome(ListNode head) {
    if (head == null) {
        return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode secondHalf = reverseList(slow.next);
    ListNode firstHalf = head;
    while (secondHalf != null) {
        if (firstHalf.val != secondHalf.val) {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }
    return true;
}

// 11. Add Two Numbers
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        current.next = new ListNode(sum % 10);
        carry = sum / 10;
        current = current.next;
    }
    return dummy.next;
}

// 12. Swap Pairs
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        second.next = first;
        current.next = second;
        current = first;
    }
    return dummy.next;
}

// 13. Intersection of Two Linked Lists
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }
    ListNode p1 = headA;
    ListNode p2 = headB;
    while (p1 != p2) {
        p1 = p1 == null ? headB : p1.next;
        p2 = p2 == null ? headA : p2.next;
    }
    return p1;
}

// 14. Delete Duplicates
public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (head != null && head.next != null) {
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            prev.next = head.next;
        } else {
            prev = head;
        }
        head = head.next;
    }
    return dummy.next;
}

// 15. Print List
public void printList(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        System.out.print(temp.val + " ");
        temp = temp.next;
    }
    System.out.println();
}

// 16. Merge K Sorted Lists
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
        return null;
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
        if (node != null) {
            pq.offer(node);
        }
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (!pq.isEmpty()) {
        ListNode node = pq.poll();
        curr.next = node;
        curr = curr.next;
        if (node.next != null) {
            pq.offer(node.next);
        }
    }
    return dummy.next;
}
}
} 

