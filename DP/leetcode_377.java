// https://leetcode.com/problems/combination-sum-iv/
// Combination Sum IV

class Solution {
    Integer[] dp ; //dp[n] = no of ways to make sum
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        if(target == 0 ||  n==0) return  0;
        dp = new Integer[target+1];
        return recursion(0, nums , target, dp);
       
    }
    public int recursion( int currsum, int nums[], int target, Integer[] dp){
        if( currsum > target) return 0;
        if(currsum ==  target){return 1; }
        if(dp[currsum] != null) return dp[currsum];

        int ways=0;
        for(int num : nums){ //this Loop will run for every number .. hence creating every possible combination
            ways += recursion(currsum + num, nums , target,dp);
        }
        return dp[currsum]= ways;

    }
}