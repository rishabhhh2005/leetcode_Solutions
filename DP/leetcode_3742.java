// https://leetcode.com/problems/maximum-path-score-in-a-grid/description/?envType=daily-question&envId=2026-05-09
// Maximum Path Score in a Grid
class Solution {
    int[][] grid; int m; int n; int k;
    Integer[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        this.grid =grid;  
        this.m=grid.length;
        this.n=grid[0].length;
        this.k=k;
        // Trying with 3D-DP
        dp = new Integer[m][n][k+1];
        int ans = helper(0,0,0); 
        return ans== Integer.MIN_VALUE?-1:ans;
        
    }
    public int helper(int i, int j , int currCost){
        if( i>=m || j>=n || currCost >k) return Integer.MIN_VALUE;  // Invalid Path

        if (grid[i][j] !=0) currCost +=1; // cut cost

        if(currCost > k) return Integer.MIN_VALUE; // Invalid Path

        if(dp[i][j][currCost] !=null) return dp[i][j][currCost];  //memoization
        
        if( i==m-1 && j==n-1 && currCost <=k) return grid[i][j];  //Valid Path

        // at every step we either go down or right
        int c1 =  helper(i+1,j, currCost);    int case1 =Integer.MIN_VALUE;
        if(c1 != Integer.MIN_VALUE) case1 = grid[i][j] + c1;

        int c2 =  helper(i,j+1, currCost);  int case2 =Integer.MIN_VALUE;
        if(c2 != Integer.MIN_VALUE) case2 = grid[i][j] + c2;

        return dp[i][j][currCost] =Math.max(case1 , case2);


    }
}