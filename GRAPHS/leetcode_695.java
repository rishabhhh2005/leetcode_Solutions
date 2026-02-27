// https://leetcode.com/problems/max-area-of-island/description/
// Max Area of Island
class Solution {
    int max =0;
    int currArea =0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == 1){ 
                    dfs(i, j, grid, visited);
                    max = Math.max(max, currArea);
                    currArea=0;
                }
            }
        }
        return max;
    }
    public void dfs(int i , int j , int[][] grid , boolean[][] visited){
        int m = grid.length;  int n = grid[0].length;
       
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(grid[i][j] == 0) return;
   
        if(grid[i][j] == 1) currArea++;
        dfs(i-1,j, grid , visited);
        dfs(i,j-1, grid , visited);
        dfs(i+1,j, grid , visited);
        dfs(i,j+1, grid , visited);
    }
}
