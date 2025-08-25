//                                                         876. Middle of the Linked List
//                                               https://leetcode.com/problems/middle-of-the-linked-list/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode curr  =head;
        int count=0;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        int middle = count/2;

        int i=0;
        ListNode move = head;
        while(i<middle){
            move = move.next;
            i++;

        }
        return move;
        
    }
}