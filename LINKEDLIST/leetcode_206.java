//                                                         206. Reverse Linked List
//                                               https://leetcode.com/problems/reverse-linked-list/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        

        
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        return prev;
        
    }
}