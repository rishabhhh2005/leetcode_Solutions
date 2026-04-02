class Solution {
    int[][] coins;
    int m ; int n ;
    Integer dp[][][];
    public int maximumAmount(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;
        this.coins = coins;
        dp = new Integer[m][n][3];
        return helper(0,0,2);
        
    }
    // return max coins
    public int helper(int i, int j , int neutrals ){
        if( i >=m || j >=n) return Integer.MIN_VALUE;
        if( i == m-1 && j == n-1){

            if(coins[i][j] <0 && neutrals > 0)  return 0; // skip
            else  return coins[i][j];
        }

        if(dp[i][j][neutrals] != null) return dp[i][j][neutrals]; //already computed

        // at curr step we need to find out first if there is a robber
        boolean safe = true;
        if(coins[i][j] < 0) safe = false;
        int res = Integer.MIN_VALUE;

        if(!safe){
            if(neutrals > 0){
                //use neutral
                int case1 = helper(i+1,j , neutrals-1); // right
                int case2 = helper(i,j+1 , neutrals-1); // down

                // get robbed and save neutral for future
                // to avoid overflow we check if moving down or right is safe or not?

                int down = helper(i+1, j, neutrals);
                int right = helper(i, j+1, neutrals);

                int case3 = (down == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + down;
                int case4 = (right == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + right;

                res= Math.max(case1, Math.max(case2,Math.max(case3, case4)));
            } 
            else{
                // get robbed
                int down = helper(i+1 , j  , neutrals);
                int right = helper(i,j+1 , neutrals);

                int case1 = (down == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + down;
                int case2 = (right == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + right;

                res= Math.max(case1 , case2);
            }

        }
        else if(safe){
            // no neutralization needed
            //move right
            int down = helper(i+1 , j , neutrals);
            int right = helper(i, j +1 , neutrals);

            int case1 = (right == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + right;
            int case2 = (down == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + down;

            res= Math.max(case1, case2);
        }

        return dp[i][j][neutrals] = res;
    
    }
}