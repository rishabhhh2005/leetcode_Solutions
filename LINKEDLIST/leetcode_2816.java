//                                                     2816. Double a Number Represented as a Linked List
//                                      https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
class Solution {
    public ListNode doubleIt(ListNode head) {
        if(head == null) return null;
        head = reverse(head);
        ListNode curr = head;

        int carry =0;
        ListNode prev =null;
        ListNode newHead = null;
        while(curr!=null){
            if(curr.val *2 >= 10){
                carry = (curr.val*2)/10;
                ans = (curr.val*2)%10;

            }
            else{
                ans = curr.val*2;
                carry=0;

            }
            ListNode newNode =  new ListNode(ans);
            if(newHead ==null){
                newHead = newNode;
                prev= newNode;
            }
            else{
                prev.next = newNode;
                prev = newNode;
            }

        }
        return newHead;
        
    }
}