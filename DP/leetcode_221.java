// https://leetcode.com/problems/maximal-square/description/
// Maximal Square
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // ❌ removed initial filling (not needed)

        // ✅ traverse bottom-right to top-left
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){

                if(matrix[i][j] == '1'){   // ✅ only for '1'

                    if(i == m-1 || j == n-1){
                        dp[i][j] = 1;   // ✅ edge case
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i+1][j],
                                      Math.min(dp[i][j+1], dp[i+1][j+1]));
                    }
                } else {
                    dp[i][j] = 0;   // ✅ important
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}