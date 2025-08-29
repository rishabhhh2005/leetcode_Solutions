//                                                      Merge Two Sorted Lists
//                                           https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode tail = null;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            ListNode chosenNode;

            if (p1.val <= p2.val) {
                chosenNode = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                chosenNode = new ListNode(p2.val);
                p2 = p2.next;
            }

            if (head == null) {
                head = chosenNode;
                tail = chosenNode;
            } else {
                tail.next = chosenNode;
                tail = chosenNode;
            }
        }

        // Adding remaining nodes if unequal list sizes
        while (p1 != null) {
            tail.next = new ListNode(p1.val);
            tail = tail.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            tail.next = new ListNode(p2.val);
            tail = tail.next;
            p2 = p2.next;
        }

        return head;
    }
}
