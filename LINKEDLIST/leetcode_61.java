//                                                              61. Rotate List
//                                              https://leetcode.com/problems/rotate-list/description/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0) return head;
        ListNode curr =head;
        int length=0;

        while(curr.next!=null){
            length++;
            curr =curr.next;
        }
        ListNode tail = curr;
        length =length+1;
  
        k = k % length;
        if (k == 0) return head;


        int target= length-k;
        curr=head;
        tail.next=head;

        
        for(int i = 1; i < target; i++){
            curr = curr.next;
        }

        head = curr.next;
        curr.next =null;
        return head;

        
    }
    
}