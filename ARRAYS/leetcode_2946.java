// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/?envType=daily-question&envId=2026-03-27
// Matrix Similarity After Cyclic Shifts
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m =mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        // i think there is no need of shifting
        // what we can actually do is.. check for every index if (index + k)%(n) == i or not
        k = k % n; // normalize k first
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //check for even row
               if(i % 2 == 0 && mat[i][j] != mat[i][(j + k) % n]) return false;
               if(i % 2 == 1 && mat[i][j] != mat[i][(j - k + n) % n]) return false;
               //check for odd row
            }
        }
        return true;        
    }
}