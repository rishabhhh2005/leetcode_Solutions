//                                                              1019. Next Greater Node In Linked List
//                                              https://leetcode.com/problems/next-greater-node-in-linked-list/description/
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr =curr.next;
        }
        int arr[] = new int[list.size()];
        int index=0;
        for( int i=0;i<list.size()-1;i++){
            boolean greaterfound =false;
            for(int j=i+1;j<list.size();j++){

                if(list.get(j) > list.get(i)){
                    arr[index++] = list.get(j);
                    j=list.size()-1;
                    greaterfound =true;
                }
            }
            if(!greaterfound){
                arr[index++] =0;
            }

        }
        arr[arr.length-1] =0;
        return arr;
        
    }
}