// https://leetcode.com/problems/minimum-path-sum/description/
// Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[]x : dp) Arrays.fill(x,-1);

        return recursion(grid, m , n,0,0,dp);
        // Simple Recursion + Memoization
        
    }

    public int recursion(int[][] grid , int m , int n, int i, int j, int[][]dp){
        if(i>=m || j>=n) return Integer.MAX_VALUE ;
        if(i == m-1 && j== n-1 ){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] = recursion(grid,m,n,i+1,j,dp) + recursion(grid,m,n,i,j+1,dp);
        return dp[i][j];
        
    }
}