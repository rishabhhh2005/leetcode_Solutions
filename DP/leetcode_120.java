// https://leetcode.com/problems/triangle/description/
// Triangle
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] x : dp) Arrays.fill(x, Integer.MAX_VALUE);
        int ans = recursion(0,0,triangle, n,dp);
        return ans;
        
    }
    public int recursion(int i, int j,List<List<Integer>> triangle,int n, int[][] dp){
        //base case

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        if( i == n-1){
            dp[i][j] = triangle.get(i).get(j);
            return dp[i][j];

        }
        dp[i][j] = triangle.get(i).get(j) + Math.min(recursion(i+1,j,triangle,n,dp) , recursion(i+1,j+1,triangle,n,dp));
        return dp[i][j];
    

    }
}