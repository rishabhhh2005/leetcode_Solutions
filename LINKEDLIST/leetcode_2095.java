//                                                              Delete the Middle Node of a Linked List
//                                                  https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return null;
        int length=0;
        ListNode curr = head;

        while(curr!=null){
            curr =curr.next;
            length++;
        }
        if(length == 1) return null;
        int mid = length/2;
        
        curr=head;
        int i=1;
        while(i<mid){
            curr =curr.next;
            i++;
        }
        curr.next =curr.next.next;

        return head;
        
    }
}