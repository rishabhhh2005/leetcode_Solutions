// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit =0;
        int min = prices[0];
        int maxprofit =0; // go to every day and subtract the minimum seen to its left so far and keep
                          // updating max profit with current profit
        for(int i=1;i<n;i++){
            int curr = prices[i];
            int currprofit = curr - min;
            maxprofit = Math.max(maxprofit, currprofit);
            min = Math.min(min ,curr);
        }
        return maxprofit;
    }
}