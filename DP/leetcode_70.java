// https://leetcode.com/problems/climbing-stairs/description/
// Climbing Stairs

class Solution {
    int[] dp = new int[46];
    Solution(){
        Arrays.fill(dp , -1);
        for(int i=0;i<=3;i++) dp[i] = i;
    }
    public int climbStairs(int n) {
        // at nth stair no of ways to reach it is n-1 + n-2
        if(dp[n] != -1) return dp[n];
        dp[n] = climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
        
    }
}