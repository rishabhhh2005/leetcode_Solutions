//                                                                        82. Remove Duplicates from Sorted List II
//                                                       https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr= head;
        ListNode prev =null;
        
        
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                while(curr.next!=null && curr.val == curr.next.val ){
                    curr = curr.next;

                }
                if(prev!=null){
                    prev.next = curr.next;
                    curr =curr.next;
                }
                else{
                    //head is duplicate 
                    head = curr.next;
                    curr = curr.next;
                    
                }
                
                

            }
            else{
                prev =curr;
                curr = curr.next;
                
            }
        }
        return head;
        
    }
}