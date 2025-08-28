//                                                              Remove Nth Node From End of List
//                                                  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        int length=0;
        ListNode curr = head;

        while(curr!=null){
            curr=curr.next;
            length++;
        }
        int toremove = length-n+1;
        if(toremove ==1) return head.next;
        curr =head;
        int i=1;
        while(i < toremove-1){
            curr= curr.next;
            i++;
        }
        
        curr.next = curr.next.next;
        

        return head;
    }
}