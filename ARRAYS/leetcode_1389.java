//                                                    LeetCode 1389 - Create Target Array in the Given Order
//                                                    https://leetcode.com/problems/create-target-array-in-the-given-order/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> myl = new ArrayList<>();

        for(int indexs : index){
            myl.add(indexs);
        }

        int[] result =new int[nums.length];
        int curr1=0;
        int curr2=0;
        for(int  i=0;i<n;i++){
            int index_to_add = index[curr2];
           
            if(curr1 > index_to_add){
                int start = curr1;
                while (start > index_to_add) {
                    int temp= result[start];
                    result[start] = result[start - 1]; 
                    result[start-1] =temp;


                    start--;
                }
            }
            
            result[ index_to_add ] = nums[curr1];
            curr1++;
            curr2++;

            

        }
        return result;
        
    }
}