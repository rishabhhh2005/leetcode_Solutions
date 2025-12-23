// https://leetcode.com/problems/cherry-pickup-ii/
// Cherry Pickup - II

class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        //3d dp becajse of 3 states we have here
        int[][][]dp = new int[r][c][c];
        for(int[][]x: dp){
            for(int[]a : x) Arrays.fill(a,-1);

        }
        return recursion(0,0,c-1,grid,r,c,dp);
        
    }
    
    public int recursion(int i , int j1  , int j2 , int[][]a, int r , int c, int[][][] dp){
        
        if(j1<0 || j2<0 || j1>=c || j2>=c) return (int)-1e9;
        if( i == r-1 ){
            if(j1 == j2) return a[i][j1];
            return a[i][j1] + a[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        

        //9 combos
        int maxi = (int)-1e9;
        for(int dj1=-1 ; dj1<=1 ; dj1++ ){
            for(int dj2=-1 ; dj2<=1 ; dj2 ++){
                if(j1 ==  j2) maxi = Math.max(maxi, a[i][j1] + recursion(i+1 , j1+dj1 , j2+dj2 , a,r,c,dp));
                else maxi = Math.max(maxi , a[i][j1] + a[i][j2] + recursion(i+1, j1+dj1 , j2+dj2 , a, r,c,dp));
            }
        }
        dp[i][j1][j2] = maxi;
        return maxi;


    }
}