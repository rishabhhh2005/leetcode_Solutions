// https://leetcode.com/problems/unique-paths-ii/description/
//Unique Paths II

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] x  : dp) Arrays.fill(x,-1);
        dp[0][0] =2;
        return recursion(0,0,m ,n, obstacleGrid,dp);
        
 
        //memoization
    }
    int count=0;
    public int recursion(int i , int j,int m , int n, int[][] obstacleGrid, int[][] dp){
        if(i>=n || j>=m) return 0;
        if( obstacleGrid[i][j] == 1) return 0;
        if(i == n-1 ||  j== m-1) return 1;
        
        if(dp[i][j] != -1){
            return dp[i][j];
            
        }
        dp[i][j] = recursion(i + 1, j, n, m, obstacleGrid, dp) +
                   recursion(i, j + 1, n, m, obstacleGrid, dp);
        return dp[i][j];
    }
}