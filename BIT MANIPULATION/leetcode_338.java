// https://leetcode.com/problems/counting-bits/description/
// 338. Counting Bits
class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[1];
        // my observation is 
        // if number is even usme utni hi set bits hongi jitni number/2 me h
        //if number is odd usme utni hi set bits hongi jitni number/2 +1  me h
        //we can use dp
        int[]dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;
   
        for(int i =0 ; i<=n;i++){
            dp[i] = dp[i/2] + (i & 1); //an extra i&1 is used to check the last bit 
            //                         bacause odd numbers have last bit set
        }
        return dp;
        
    }

}
