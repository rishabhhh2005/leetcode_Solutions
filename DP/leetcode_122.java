// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// Best Time to Buy and Sell Stock II
class Solution {// RECURSION 
    Integer dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return recursion(0,0, prices); // 0-> Not buyed  1-> buyed
    }
    public int recursion(int index, int buyed , int[]prices){
        if(index >= prices.length) return 0;
        if(dp[index][buyed] != null) return dp[index][buyed];
        int profit1 =0;
        int profit2 =0 ;

        if(buyed == 0){ // buy or not buy
            int case1 = -prices[index] + recursion(index+1, 1 , prices); // BUY 
            int case2 = 0 + recursion(index+1 , 0, prices);  // DONT BUY 
            profit1 = Math.max(case1 , case2);

        }

        else{  // sell or not sell
            int case1 = prices[index] + recursion(index+1, 0, prices); // SELL
            int case2 = 0 + recursion(index+1 , 1, prices);  // DONT SELL
            profit2 = Math.max(case1 , case2);

        }
        return dp[index][buyed] =Math.max(profit1 , profit2);

    }
}