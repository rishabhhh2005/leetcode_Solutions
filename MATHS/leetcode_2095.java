// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=daily-question&envId=2026-06-15
// Delete the Middle Node of a Linked List
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if( head.next == null) return null; // edge case
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowprev = head;
        while(fast != null && fast.next !=null){
            slowprev = slow;
            slow = slow.next;
            fast = fast.next.next;            
        }
        // at this point slow prev points just before the node we want to delete
        if(slow.next == null) slowprev.next =null;
        else slowprev.next = slow.next;

        return head;        
    }
}