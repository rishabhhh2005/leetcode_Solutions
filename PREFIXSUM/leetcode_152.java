// https://leetcode.com/problems/maximum-product-subarray/description/
// Maximum Product Subarray
class Solution {
    public int maxProduct(int[] nums) {
        int n  = nums.length;
        //base cases
        if(n == 0) return  0;
        if( n==1) return nums[0];
        //the idea is
        //  do Prefix sum from    LEFT --> RIGHT
        //  do Suffix sum from    LEFT <-- RIGHT
        // and keep udpdating max
        // if we encounter any 0 -> just update prefixsum or suffixsum as 1
        int max =0;
        int prefixsum =1;
        int suffixsum =1;
        for(int i=0;i<n;i++){
            if(prefixsum == 0) prefixsum =1;
            if(suffixsum == 0) suffixsum =1;

            prefixsum = prefixsum * nums[i];
            suffixsum = suffixsum * nums[n-i-1];
            max = Math.max(max, Math.max(prefixsum, suffixsum));
        }
        return max;
        
    }
}
