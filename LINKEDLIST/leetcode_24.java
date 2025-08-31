//                                                                        24. Swap Nodes in Pairs
//                                                       https://leetcode.com/problems/swap-nodes-in-pairs/description/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head ==null) return null;
        if(head.next == null) return head;
        ListNode curr = head;
        ListNode prev =null;
        boolean headfound =false;
        while(curr!=null && curr.next!=null){
            if(!headfound){
                ListNode temp1 = new ListNode(0);
                temp1.next =curr;
                head = curr.next;
                curr=curr.next;

                ListNode temp2 = new ListNode(0);
                temp2.next = curr.next;
                curr.next =temp1.next;
                curr =curr.next;
                curr.next = temp2.next;

                prev=curr;
                headfound =true;
                curr =curr.next;
            }
            else{
                prev.next = curr.next;
                ListNode temp1 = new ListNode(0);
                temp1.next =curr;
                curr =curr.next;
                ListNode temp2 = new ListNode(0);
                temp2.next = curr.next;
                curr.next = temp1.next;
                curr =curr.next;
                curr.next =temp2.next;
                prev =curr;
                curr =curr.next;

            }



        }
        return head;
    }
}

// a litte bit complicated but it works