//                                                     142. Linked List Cycle II 
//                                          https://leetcode.com/problems/linked-list-cycle-ii/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode  fast = head;

        while(fast.next!= null && fast.next.next !=null){
           
            slow = slow.next;
            fast= fast.next.next;
            if (slow == fast) {
                ListNode pointer =head;
                while(pointer !=slow){
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;
            }
        }

        return null;        
    }
}