//                                                              Sort List
//                                                  https://leetcode.com/problems/sort-list/
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode curr =head;
        while(curr!=null){
            list.add(curr.val);
            curr =curr.next;
        }
        Collections.sort(list);
        ListNode newhead =null;
        ListNode prev =null;
        for(int i=0;i<list.size();i++){
            ListNode newnode = new ListNode(list.get((i)));
            if(i>0)prev.next =newnode;
            if(i==0) newhead =newnode;
            if(i == list.size()-1) {
                newnode.next =null;
                break;
            }
            prev = newnode;
        }
        return newhead;
    }
}