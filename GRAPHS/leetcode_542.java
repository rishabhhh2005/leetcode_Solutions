// https://leetcode.com/problems/01-matrix/submissions/1919831004/
// 01 Matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Do Bfs from all zeroes
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q  = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i,j,0});
                    res[i][j] = 0;
                }
                else{
                    res[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int nr = curr[0];
            int nc = curr[1];
            int dist = curr[2];

            if(nr+1 < m && res[nr+1][nc] == -1){
                res[nr+1][nc] = dist+1;
                q.offer(new int[]{nr+1,nc,dist+1});
            }
            if(nr - 1 >= 0 && res[nr - 1][nc] == -1){
            res[nr - 1][nc] = dist + 1;
            q.offer(new int[]{nr - 1, nc, dist + 1});
            }

            if(nc + 1 < n && res[nr][nc + 1] == -1){
            res[nr][nc + 1] = dist + 1;
            q.offer(new int[]{nr, nc + 1, dist + 1});
            }

            if(nc - 1 >= 0 && res[nr][nc - 1] == -1){
            res[nr][nc - 1] = dist + 1;
            q.offer(new int[]{nr, nc - 1, dist + 1});
            }



        }
        return res;
        
    }
}