//                                                     2181. Merge Nodes in Between Zeros
//                                      https://leetcode.com/problems/merge-nodes-in-between-zeros/description/
class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode curr =head.next;
        int sum=0;
        ListNode newHead = null;
        ListNode prev =null;
        
        while(curr!=null){
            if(curr.val == 0){
                ListNode newNode = new ListNode(sum);
                if(newHead == null){
                    newHead = newNode;
                    prev= newNode;
                }
                else{
                    prev.next = newNode;
                    prev = newNode;
                }
                sum =0;
                curr =curr.next;
                
            }
            else{
                sum+=curr.val;
                curr =curr.next;
            }

        }
        return newHead;
        
    }
}