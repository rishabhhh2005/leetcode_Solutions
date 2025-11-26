//https://leetcode.com/problems/fibonacci-number/description/
// Fibonacci Number
class Solution {
    int[]dp = new int[31];
    public Solution(){
        Arrays.fill(dp , -1);
        dp[0] = 0;
        dp[1] = 1;
    }// we used Memorization to avoid extra Time Complexity
    
    public int fib(int n) {
        if(dp[n] != -1) return dp[n];
        dp[n] =fib(n-1) + fib(n-2); // we store the result in the 1-D array as soon as we found one
        return dp[n];        
    }
}