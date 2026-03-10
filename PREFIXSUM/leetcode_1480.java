// https://leetcode.com/problems/running-sum-of-1d-array/
// Running Sum of 1d Array
class Solution {
    public int[] runningSum(int[] nums) {
        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i=1; i<nums.length;i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        return prefixsum;
        
    }
}