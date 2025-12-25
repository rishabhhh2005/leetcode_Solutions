// https://leetcode.com/problems/target-sum/description/
// Target Sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total =0;
        for(int x : nums) total+=x;
        //try out all possible ways
        Integer[][]dp = new Integer[n][(2*total)+1];
        //since the sum range is from [-total ... to ... +total] we will shift by +total
        return recursion(0,nums,target,0,total,dp);
  
        
    }

    public int recursion(int index , int[] nums , int target, int sum, int total,Integer[][] dp){
        if(index == nums.length) return sum == target?1:0;

        if(dp[index][sum+total] != null) return dp[index][sum+total];
        // plus
        int countbyplus = recursion(index+1 , nums , target, sum+nums[index],total,dp);
        //minus
        int countbyminus = recursion(index+1 , nums , target, sum-nums[index],total,dp);
        return dp[index][sum + total] = countbyplus + countbyminus;
    }
}