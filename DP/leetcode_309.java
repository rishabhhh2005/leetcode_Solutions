// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
// Best Time to Buy and Sell Stock with Cooldown
class Solution { // same approach  cases arise
// try out all possible ways
  // WE will be aplying recursion + memoization here because we can have 
    // many cases arise so we wil go with DP + MEMOIZATION
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        dp = new Integer[n][2];
        return recursion(0,0,prices);
        
    }
    public int recursion(int index, int buy ,  int [] prices){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != null) return dp[index][buy];
        int p1=0;   int p2 =0;
        
        if(buy == 0){ // if not buyed
            int case1 = -prices[index] + recursion(index+1 , 1 , prices) ; // buy
            int case2 = 0 + recursion(index+1 , 0,  prices) ; // dont buy
            p1 = Math.max(case1 , case2);
        }
        else{ // if buyed
            int case1 = prices[index] + recursion(index+2 , 0, prices)   ;  //sell  // we will move 2 steps 
            int case2 = 0 + recursion(index+1 , 1,  prices)   ; // dont sell
            p2 = Math.max(case1 , case2);

        }
        return dp[index][buy] =Math.max(p1 ,p2);
    }
}