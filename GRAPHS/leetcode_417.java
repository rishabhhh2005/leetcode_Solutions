// 417. Pacific Atlantic Water Flow
// https://leetcode.com/problems/pacific-atlantic-water-flow/description/
class Solution {
    List<List<Integer>> res=  new ArrayList<>();
    boolean[][] pacific ;// (i,0) and (0,j)
    boolean[][] atlantic; // (i,n-1) and (m-1,j)

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    // one thing i have observed is
    // pacific ocean  -> if it goes out of bonds in 0 
    // atlntic ocean -> if it goes out of bonds in m /n
        int m = heights.length;
        int n = heights[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        // do dfs for pacific
        for(int i=0;i<m;i++)  dfs(i,0,pacific,heights);
        for(int j=0;j<n;j++)  dfs(0,j,pacific,heights);

        // do dfs for atlantic
        for(int i=0;i<m;i++) dfs(i,n-1, atlantic, heights);
        for(int j=0;j<n;j++) dfs(m-1,j,atlantic , heights);

    // take intersection
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add( new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;


    }
    public void dfs(int i ,int j , boolean[][]visited, int[][] heights){
        int m = heights.length;   int n = heights[0].length;
        if(i<0 || j <0 || i>=m || j >=n) return;
        if(visited[i][j]) return;
        visited[i][j] =true;
        if(i-1 >=0 && heights[i-1][j] >= heights[i][j]) dfs(i-1,j,visited,heights);
        if(i+1 <m && heights[i+1][j] >= heights[i][j]) dfs(i+1,j,visited,heights);
        if(j-1 >=0 && heights[i][j-1] >= heights[i][j]) dfs(i,j-1,visited,heights);
        if(j+1 <n && heights[i][j+1] >= heights[i][j]) dfs(i,j+1,visited,heights);
        
// we did >= because we are doing DFS OPPOSITE
// NOT FROM  TILE - TO - TILE  BUT FROM ISLAND - TO - TILE
       

    }
}