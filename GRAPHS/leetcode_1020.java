// https://leetcode.com/problems/number-of-enclaves/description/
// Number of Enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        //Create a visited matrix  +  4 Boundary Traversals  +  DFS + compare to new matric
        int n = grid.length;
        int m= grid[0].length;
        int[][] safegrid = new int[n][m];
       
        boolean[][] visited = new boolean[n][m];

        for(int j=0;j<m;j++){
            if(!visited[0][j] && grid[0][j] == 1){
                dfs(0,j , grid  , visited);
            }

        }
        for(int i=0;i<n;i++){
            if(!visited[i][0] && grid[i][0] == 1){
                dfs(i,0 , grid  , visited);
            }

        }
        for(int j=0;j<m;j++){
            if(!visited[n-1][j] && grid[n-1][j] == 1 ){
                dfs(n-1,j , grid  , visited);
            }

        }
        for(int i=0;i<n;i++){
            if(!visited[i][m-1] && grid[i][m-1] == 1 ){
                dfs(i,m-1 , grid  , visited);
            }

        }
        //end me

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == true){
                    safegrid[i][j] = 1;
                }
                else {
                    safegrid[i][j] = 0;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(safegrid[i][j] != grid[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i , int j , int[][] grid , boolean[][]visited){
       
        
        int n = grid.length;
        int m = grid[0].length;
         if(visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;

        if(i > 0 && grid[i-1][j] == 1){
            dfs(i-1 ,j , grid  , visited);
        }
        if(i+1 <n && grid[i+1][j] == 1){
            dfs(i+1 ,j, grid, visited);
        }
        if(j > 0 && grid[i][j-1] == 1){
            dfs(i ,j-1, grid, visited);
        }
        if(j+1 <m  && grid[i][j+1] == 1){
            dfs(i , j+1,grid, visited);
        }

    }
}