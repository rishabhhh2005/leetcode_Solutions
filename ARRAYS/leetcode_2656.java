// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
// Maximum Sum With Exactly K Elements 
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for(int x : nums) max = Math.max(max,x);
        int ans =0;
        while(k-->0){
            ans+= max;
            max = max+1;
        }
        return ans;
        
    }
}