//                                                              817. Linked List Components
//                                              https://leetcode.com/problems/linked-list-components/description/
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        if(head == null) return 0;
        int count=0;
        ListNode curr = head;
        boolean camefromrecentcomponent =false;
        while(curr!=null){
            if(curr.next == null && list.contains(curr.val)){
                count++;
                break;
            }
            if(!list.contains(curr.val) &&  !camefromrecentcomponent){
                curr = curr.next;
                continue;
            }
            else if(!list.contains(curr.val) && camefromrecentcomponent ){
                count++;
                camefromrecentcomponent =false;
                curr = curr.next;

            }
            else{
                camefromrecentcomponent =true;
                curr = curr.next;
            }

        }
        
        return count;
    }
}