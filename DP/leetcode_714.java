// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
// Best Time to Buy and Sell Stock with Transaction Fee
class Solution {
    Integer[][] dp ;
    // WE will be aplying recursion + memoization here because we can have 
    // many cases arise so we wil go with DP + MEMOIZATION
    public int maxProfit(int[] prices, int fee) {
        dp= new Integer[prices.length][2];
        return recursion(0,0,fee,prices); //  0-> noy buyed  1-> buyed
        
    }
    public int recursion(int index, int buy , int fee , int [] prices){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != null) return dp[index][buy];
        int p1=0;   int p2 =0;
        
        if(buy == 0){ // if not buyed
            int case1 = -prices[index] + recursion(index+1 , 1, fee , prices) ; // buy
            int case2 = 0 + recursion(index+1 , 0, fee, prices) ; // dont buy
            p1 = Math.max(case1 , case2);
        }
        else{ // if buyed
            int case1 = prices[index] + recursion(index+1 , 0, fee , prices) - fee   ;  //sell  // we will cut fees only when we sell
            int case2 = 0 + recursion(index+1 , 1, fee, prices)   ; // dont sell
            p2 = Math.max(case1 , case2);

        }
        return dp[index][buy] = Math.max(p1 ,p2);
    }
}