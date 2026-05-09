// https://leetcode.com/problems/rotate-function/description/?envType=daily-question&envId=2026-05-09
// Rotate Function
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
      
        int[] dp = new int[n];
        int currsum =0; int totalsum=0;
        for(int i=0;i<n;i++){
            currsum += nums[i]*i;
            totalsum += nums[i];
        }
        dp[0] = currsum;
        int max = dp[0];
        for(int i=1;i<n;i++){
            //  use derived formula
            // f(k) = f(k-1) + totalsum -n * nums[elementmovedtoFront]
            dp[i] = dp[i-1]  + totalsum - (n * nums[n-i]);
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
}