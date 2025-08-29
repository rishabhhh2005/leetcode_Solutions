//                                                                        Add Two Numbers
//                                                          https://leetcode.com/problems/add-two-numbers/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;
        boolean headmadeyet=false;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode prev = null;

        ListNode head =null;
        int carry=0;
        while(p1 !=null || p2!=null || carry !=0){
            int val1 =(p1 != null )?p1.val:0;
            int val2 = (p2!=null)?p2.val:0;

            int sum = val1+val2 +carry;
            carry = sum/10;
            int digit = sum%10;
            ListNode newNode = new ListNode(digit);
            if(head == null){
                head =newNode;
                prev =newNode;
            }
            else{
                prev.next = newNode;
                prev =newNode;
            }
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        return head;
        
        
    }
}