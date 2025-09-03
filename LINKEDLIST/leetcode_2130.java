//                                                              2130. Maximum Twin Sum of a Linked List
//                                              https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
class Solution {
    public int pairSum(ListNode head) {
        if(head == null) return 0;
        ListNode curr = head;
        int length=0;
        while(curr!=null){
            curr =curr.next;
            length++;
        }
        int mid =length/2;
        curr = head;
        int i=0;
        while(i<mid) {
            i++;
            curr =curr.next;
        }
        ListNode p1 = head;
        ListNode p2 = reverse(curr);
        int maxsum = Integer.MIN_VALUE;
        for (int j = 0; j < mid; j++) {
            int sum = p1.val + p2.val;
            maxsum = Math.max(sum, maxsum);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxsum;

        
    }
    public ListNode reverse(ListNode head){
        ListNode curr =head;
        ListNode prev =null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}