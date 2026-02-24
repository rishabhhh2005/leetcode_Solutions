// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// Min Cost Climbing Stairs
class Solution {
    Integer[] dp; // dp[index] = minimum cost to reach top starting from index
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0 ) return 0;
        if(n==1) return cost[0];
        int sum=0;
        for(int x:cost) sum+=x;
        if(sum == 0) return 0;
        dp = new Integer[n];
        return Math.min(recursion(0,cost,dp), recursion(1,cost,dp));

        
    }
    public int recursion(int index ,int[] cost, Integer[] dp){

        if(index >= cost.length){
            return 0;
        } 
        if(dp[index]!= null) return dp[index];

        int one = cost[index] + recursion(index+1, cost,dp);
        int two = cost[index] + recursion(index+2 ,cost,dp);
        return dp[index] =Math.min(one,two);
    }
}
