// https://leetcode.com/problems/house-robber/description/
// House Robber

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        if(nums.length == 1) return nums[0];
        //make sure to note we are storing the best Amount of money at i index in DP.. and not the current robbed money..
        //that means if we are at dp[5] we mean from {0....5} this is the best money so far
        Arrays.fill(dp , -1);
        dp[0] =nums[0] ;
        dp[1] = Math.max(nums[0], nums[1]);
        // SIMPLE DP TABULATION
        for(int i=2;i<nums.length;i++){
            dp[i] =  Math.max(dp[i-1] , nums[i]+ dp[i-2]);

        }
        return dp[nums.length-1];
        
    }
}