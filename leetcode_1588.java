//                                      LeetCode Problem 1588: Sum of All Odd Length Subarrays
//                                      https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int fsum=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j+=2){
                for(int k=i;k<=j;k++){
                    
                    fsum +=arr[k];
                    
                }
            }
            

        }
        return fsum;
        
    }
}