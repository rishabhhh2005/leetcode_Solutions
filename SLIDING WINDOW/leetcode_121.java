// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l =0;
        int max = 0;
        int r=1;
        while(r<n){
            int currprofit=0;
            if(prices[l] > prices[r]) l=r;
            else{
                 currprofit = prices[r] - prices[l];
               
            }
             max = Math.max(max, currprofit);
            r++;
        }
        return max;
        
    }
}