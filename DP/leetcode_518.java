// https://leetcode.com/problems/coin-change-ii/description/
// Coin Change II

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][]dp = new Integer[n+1][amount+1];
        return recursion(0,0,coins,n,amount,dp);

        
    }
 
    public int recursion(int index ,int currsum, int[] coins , int n, int amount, Integer[][] dp){
        if(currsum == amount) return 1;
        if(currsum > amount || index >=n) return 0;
        if(dp[index][currsum] != null) return dp[index][currsum];
        
        //take
        int take = recursion(index, currsum + coins[index], coins ,n,amount,dp);
        //no take
        int notake = recursion(index+1,currsum, coins,n,amount,dp);

        return dp[index][currsum] = take + notake;
    }
}