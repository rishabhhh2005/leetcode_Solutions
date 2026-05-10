// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/?envType=daily-question&envId=2026-05-10
// Maximum Number of Jumps to Reach the Last Index
class Solution {
    int[] nums; int n; int target;
    Integer[] dp ;
    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;  this.n = nums.length;  this.target = target;
        dp = new Integer[n];
        int ans =helper(0);
        return ans == Integer.MIN_VALUE?-1:ans;
    
    }

    public int helper(int index){
        if(index >=n) return Integer.MIN_VALUE;
        if(index == n-1){
            return 0; //No More jumps needed from the Last Index
        }
        if(dp[index] != null) return dp[index];

        int maximumJumps =Integer.MIN_VALUE;
        for(int start = index+1;start <n; start++){
            int val =nums[start] - nums[index];
            if(-target <= val && val <= target){
                // we can jump tp the index " start "
                int next = helper(start);
                if(next != Integer.MIN_VALUE) maximumJumps = Math.max(maximumJumps, 1 + next); 
        
            }
        }
        return dp[index] = maximumJumps;
    }
}