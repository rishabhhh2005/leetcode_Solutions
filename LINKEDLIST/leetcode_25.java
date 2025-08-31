//                                                                        25. Reverse Nodes in k-Group
//                                                       https://leetcode.com/problems/reverse-nodes-in-k-group/description/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1) return head;
        ListNode curr = head;
        int length=0;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        if(k > length) return head;
        curr =head;
        boolean headfound = false;
        ListNode prevTail = null;
        while(curr!=null && curr.next!=null){
            ListNode start = curr;
            ListNode move = curr;
            int nodes=0;

            
            while (nodes < k && move != null) {
                move = move.next;
                nodes++;
            }
            if (nodes < k) {
                break; // Not enough nodes to reverse, leave as is
            }

            ListNode temp = move;
            ListNode breaker = start;
            for (int i = 1; i < k; i++) {
                breaker = breaker.next;
            }
            breaker.next = null;
            
            ListNode newNode =reverse(start);
            if(!headfound){
                head = newNode;
                headfound=true;
            }
            else {
                prevTail.next = newNode;
            }

            ListNode current = newNode;
            while(current.next!=null){
                current =current.next;
            }
            current.next =temp;
            prevTail = current;

            curr = current.next;
        }
        return head;



        
        
    }
    public ListNode reverse(ListNode head){
        ListNode curr =head;
        ListNode prev =null;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next =prev;
            prev =curr;
            curr =next;
        }
        return prev;

    }
}