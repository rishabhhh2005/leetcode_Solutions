// https://leetcode.com/problems/island-perimeter/description/
// Island Perimeter
class Solution {
    int perimeter =0;
    int[][] grid;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        // Approach i can think of is  (Do Dfs + Everytime you go out of Bonds... Just Add 1  to the ans)
        this.visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(!visited[i][j] && grid[i][j] == 1) {dfs(i,j,m,n); return perimeter;}
            }
        }
        return 0;      
    }
    public void dfs(int i , int j, int m , int n  ){
        if( i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0){
            perimeter+=1;
            return;
        }

        if( visited[i][j]) return;
        visited[i][j] = true;
        dfs(i-1,j,m,n);
        dfs(i+1,j,m,n);
        dfs(i,j-1,m,n);
        dfs(i,j+1,m,n);

    }
}