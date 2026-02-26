// https://leetcode.com/problems/product-of-array-except-self/
// Product of Array Except Self
class Solution {//simple hai
//for every element It's value = it's prefixsum * uska suffixsum
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix =new int[n];       int[] suffix = new int[n];
        int pre=1;    int suf=1;
        for(int i=0,j=n-1; i<n && j>=0 ; i++,j-- ){
            prefix[i] = pre;
            suffix[j] =suf;

            pre *= nums[i];
            suf *= nums[j];
            
        }

        int[] res = new int[n];
        for(int index =0; index<n;index++){
            res[index] =prefix[index]*suffix[index];
        }
        return res;
        
    }
}