// https://leetcode.com/problems/next-greater-element-i/
// Next Greater Element I

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result ,-1);
        for(int i=0;i<nums1.length;i++){
            int current = nums1[i];
            boolean findgreaternow = false;
            int[] greater = new int[1];
            Arrays.fill(greater ,-1);
            for(int j=0;j<nums2.length;j++){

                if(findgreaternow){
                    if(nums2[j] > current){
                        greater [0] =nums2[j];
                        break;
                    }
                }
                else{
                    if(nums2[j] == current){
                    findgreaternow =true;}
                }

                
                
            }

            if(greater[0] != -1){
                    result[i] = greater[0];
            }
            
        }
        

        return result;
    }
}