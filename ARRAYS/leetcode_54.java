// https://leetcode.com/problems/spiral-matrix/description/?envType=problem-list-v2&envId=oizxjoit
// Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //right , down , left , up  with visited
        int m= matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int count =0;
        int row = 0; int col =0;
        while (count <= m*n-1){
            // right
            while ( col < n && !visited[row][col]){
                visited[row][col] = true;
                res.add( matrix[row][col]);
                count++;
                col++;
            }
            col--;
            row++;
            //down
            while(row < m && !visited[row][col]){
                visited[row][col] = true;
                res.add(matrix[row][col]);
                count++;
                row++;
            }
            col--;
            row--;
            // left
            while(col >=0 && !visited[row][col]){
                visited[row][col] = true;
                res.add(matrix[row][col]);
                count++;
                col--;
            }
            col++;
            row--;
            //up
            while(row >=0 && !visited[row][col]){
                visited[row][col] = true;
                res.add(matrix[row][col]);
                count++;
                row--;
            }
            row++;
            col++;
        }
        return res;
        
    }
}