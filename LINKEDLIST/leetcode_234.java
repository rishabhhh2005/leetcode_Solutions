//                                                        234. Palindrome Linked List
//                                          https://leetcode.com/problems/palindrome-linked-list/description/
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        int length =0;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        int mid = length/2;
        curr =head;
        int start=0;
        while(start!=mid){
            curr = curr.next;
            start++;
        }
        ListNode prev =null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next =prev;
            prev = curr;
            curr=next;
        }
        ListNode go=head;
        while(prev!=null){
            if(go.val != prev.val) return false;
            go = go.next;
            prev = prev.next;
        }
        return true;
        
    }
}