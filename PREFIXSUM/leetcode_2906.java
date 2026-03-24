// https://leetcode.com/problems/construct-product-matrix-from-a-given-matrix/description/
// Construct Product Matrix from a Given Matrix
class Solution {
    // to solve this. we can use prefixproduct and suffixproduct array
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefix = new int[n][m];
        int[][] suffix = new int[n][m];
        int prev =1;
        for(int i=0;i<n;i++){
            for(int j= 0 ;j<m;j++){
               prefix[i][j] = prev;
                prev = (prev * (grid[i][j] % 12345)) % 12345;
            }
        } 
        prev =1 ;    
        for(int i=n-1;i>=0;i--){
            for(int j= m-1 ;j>=0;j--){
                suffix[i][j] =  prev;
                prev = (prev * (grid[i][j] % 12345)) % 12345;
            }
        }   

        int[][] res = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j =0; j<m;j++){
               res[i][j] = (prefix[i][j] * suffix[i][j]) % 12345;
            }
        }  
        return res;
    }
}