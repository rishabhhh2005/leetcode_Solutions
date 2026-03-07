// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/description/
class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return rec(0,-1,nums);
   
    }
    public int rec(int curr, int prev , int[] nums){
       
        if(curr >= nums.length){
            return 0 ;
        }
        if(dp[curr][prev+1] != null) return dp[curr][prev+1]; 
        // we are using prev +1  because to make -1 ->0 and this way we will go
        // from -1 ..... n-1  but  actually 0 ..... n

        // no take
        int notake =rec(curr+1 ,prev , nums);

        // take only if it is strictly increasing or nothing is choosen
        int take =0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + rec(curr+1,curr, nums);
        }
        return dp[curr][prev+1] = Math.max( take , notake);

    }
}