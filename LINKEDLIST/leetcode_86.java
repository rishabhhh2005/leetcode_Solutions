//                                                              86. Partition List
//                                              https://leetcode.com/problems/partition-list/description/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greatHead;
        ListNode curr = head;

        while(curr!=null){

            if(curr.val < x){
                less.next = curr;
                less = less.next;
            }
            else{
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        greater.next =null;
        less.next = greatHead.next;

        return lessHead.next;
        
    }
}