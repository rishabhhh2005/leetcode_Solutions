//                                                             147. Insertion Sort List
//                       https://leetcode.com/problems/insertion-sort-list/description/?envType=problem-list-v2&envId=linked-list
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head.next;
        
        ListNode lastSortedval = head;
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        
        while(curr!=null){
            
            if(curr.val >= lastSortedval.val){
                lastSortedval = curr;
            }
            else{
                ListNode prev = dummy;
                while(prev.next.val < curr.val){
                    prev = prev.next;
                }
                lastSortedval.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;

            }
            curr = lastSortedval.next;

            
        }
        return dummy.next;
        
    }
}