// https://leetcode.com/problems/merge-k-sorted-lists/
// Merge k Sorted Lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
// This is a very easy question if we know PQ/Min Heap
// just add All heads into the PQ and then they come out sorted way and then keep on making lists and adding head's next to the PQ
        for(ListNode head : lists){
            if(head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(-1);

        ListNode head = dummy;
        ListNode curr = head;

        while(!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            curr.next= nextNode;
            if(nextNode.next != null ) pq.offer(nextNode.next);
            curr = curr.next;
            curr.next =null;
        }
        return head.next;

        
    }
}