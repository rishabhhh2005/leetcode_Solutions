// https://leetcode.com/problems/unique-paths/description/
//  Unique Paths

class Solution {    
    public int uniquePaths(int m, int n) {
        //simple dfs
        int[][] dp = new int[m][n];
        for(int []x: dp) Arrays.fill(x,-1);
        // [-1, -1, -1]
        // [-1, -1, -1]
        // [-1, -1, -1]
        return topDown(0,0,dp);
        
    }

    public int topDown(int i, int j ,int[][] dp){
        int m = dp.length;
        int n=  dp[0].length;

        if(i>=m || j>=n) return 0;
        if(i == m-1 && j== m-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int down = topDown(i+1,j,dp);
        int right = topDown(i,j+1,dp);

        return dp[i][j] = down + right;

    }
}