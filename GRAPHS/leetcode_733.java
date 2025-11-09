// https://leetcode.com/problems/flood-fill/\
// FLood Fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] res = image;

        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int oldColor = image[sr][sc];
        res[sr][sc] = color;


        while(!q.isEmpty()){
            int [] curr = q.poll();
            int i=curr[0];
            int j =curr[1];

            if(i-1>=0 && !visited[i-1][j] && image[i-1][j] == oldColor){
                q.offer(new int[]{i-1,j});
                visited[i-1][j] =true;
                res[i-1][j]=color;
            }
            if(j-1>=0 && !visited[i][j-1] && image[i][j-1] == oldColor){
                q.offer(new int[]{i,j-1});
                visited[i][j-1] =true;
                res[i][j-1]=color;
            }
            if(i+1<n && !visited[i+1][j] && image[i+1][j] == oldColor){
                 q.offer(new int[]{i+1,j});
                 visited[i+1][j] = true ;
                res[i+1][j]=color;
            }
            if(j+1<m && !visited[i][j+1] && image[i][j+1] == oldColor){
                 q.offer(new int[]{i,j+1});
                 visited[i][j+1] = true;
                res[i][j+1]=color;
            }
        }
        return res;
        
    }
}