//                                                              Odd Even Linked List
//                                                  https://leetcode.com/problems/odd-even-linked-list/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        

        while(even!=null && even.next!=null){
            
            
            odd.next = even.next;
            odd =even.next;
            
            
            even.next =odd.next;
            even = even.next;
            
        }
        odd.next =evenhead;
        return head;
        
    }
}