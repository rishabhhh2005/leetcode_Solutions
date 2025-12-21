// https://leetcode.com/problems/minimum-falling-path-sum/
// Minimum Falling path sum
class Solution {
       
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int[n][n];
        for(int [] x : dp) Arrays.fill(x,Integer.MAX_VALUE);
        int finalsum = Integer.MAX_VALUE;
       for(int j=0;j<n;j++){
        int currsum = recursion(0,j,matrix,n,dp);
        finalsum =Math.min(currsum,finalsum);
       }
       return finalsum;

    }

    public int recursion(int i ,int  j , int[][] matrix, int n, int[][] dp){
        if(i >=n || j>=n || i<0 || j<0) return  Integer.MAX_VALUE;
        if(dp[i][j] != Integer.MAX_VALUE)  return dp[i][j];
        if(i==n-1 ){
            return matrix[i][j];
            
        }
        //go down
        int down =recursion(i+1,j,matrix,n,dp);
        //go left diag
        int leftdiag = recursion(i+1,j-1,matrix,n,dp);
        //go right diag
        int rightdiag =recursion(i+1,j+1,matrix,n,dp);
        dp[i][j] = matrix[i][j] + Math.min(down , Math.min(leftdiag, rightdiag));
        return dp[i][j];
        



    }
}