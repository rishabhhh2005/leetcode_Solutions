// https://leetcode.com/problems/coin-change/
// Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        Integer[][]dp = new Integer[n+1][amount+1];
        //greedy wont work here
        // try all possible ways (recursion) + memoize [TOP DOWN]
        int ans = recursion(n-1 , amount , coins,dp) ;
        return ans == Integer.MAX_VALUE?-1:ans;
        
    }
    public int recursion(int index , int target , int[]coins, Integer[][] dp){
        //base cases
        if(target == 0) return 0;
        if(index <0) return Integer.MAX_VALUE;
        if(dp[index][target] != null) return dp[index][target];

        //no take coin
        int notake = 0 + recursion(index-1, target , coins,dp);
        //take coin
        int take = Integer.MAX_VALUE;
        if(coins[index] <= target){
            int sub = recursion(index , target - coins[index], coins,dp);
            if(sub != Integer.MAX_VALUE) // to prevent overflow
                 take = 1 + sub; 

        }
        dp[index][target] =Math.min(take , notake);
        return dp[index][target];
    }

}