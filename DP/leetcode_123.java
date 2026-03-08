// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
// Best Time to Buy and Sell Stock III
class Solution { // 3D DP QUESTION
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        // we will try out aall possible ways
        int n = prices.length;
        dp = new Integer[n][2][3];
        return helper(0,0,2,prices);
    }
    public int helper(int index, int buyed, int limit , int[] prices){
        if(index >= prices.length || limit ==0) return 0;
        if(dp[index][buyed][limit] != null) return dp[index][buyed][limit];
        int p1 =0;   int p2 =0;

        if(buyed == 0){ // if not buyed
            int case1 = -prices[index] + helper(index+1 , 1, limit,prices); // buy
            int case2 = 0 + helper(index+1 , 0, limit,prices); // leave
            p1 = Math.max(case1 , case2);
        }
        else{ // if buyed
            int case1 = prices[index] + helper(index+1 , 0, limit-1,prices); // decrease a transaction when we sell
            int case2 = 0 + helper(index+1 , 1, limit,prices); // leave
            p2 = Math.max(case1 , case2);
            
        }
        return dp[index][buyed][limit]=Math.max(p1 , p2); // get the max case
    }
}