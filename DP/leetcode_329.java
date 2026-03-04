// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
// Longest Increasing Path in a Matrix
class Solution {
    
    Integer[][] dp; // dp[i][j] = Max path from this block
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        dp = new Integer[m][n];
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                ans = Math.max(ans, dfs(i,j,0,Integer.MIN_VALUE,visited,matrix) );      
            }
        }
        return ans;
        
    }
    public int dfs(int i , int j ,int curr, int prev,  boolean[][] visited, int[][] matrix){
        int m = matrix.length;   int n = matrix[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j]) return 0;
        if(matrix[i][j] <= prev) return 0;
        if(dp[i][j] != null) return dp[i][j];
        visited[i][j] = true;
      
        int down = dfs(i+1,j, curr+1, matrix[i][j], visited, matrix);
        int right = dfs(i,j+1, curr+1, matrix[i][j], visited, matrix);
        int up = dfs(i-1,j, curr+1,  matrix[i][j],  visited, matrix);
        int left =dfs(i,j-1, curr+1,  matrix[i][j],  visited, matrix);
        visited[i][j] = false;
       return dp[i][j] = 1 + Math.max(up, Math.max(down, Math.max(right, left)));

    }
}
