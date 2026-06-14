// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=daily-question&envId=2026-06-14
// Maximum Twin Sum of a Linked List
class Solution {
    public int pairSum(ListNode head) {
        // max twin sum
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while(curr!=null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int p1 =0;
        int p2 = arr.size()-1;

        while(p1<p2){
            int currsum = arr.get(p1) + arr.get(p2);
            max =Math.max(max, currsum);
            p1++;
            p2--;
        }
        return max;
        
    }
}