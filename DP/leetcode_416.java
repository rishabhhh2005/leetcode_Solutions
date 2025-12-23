// https://leetcode.com/problems/partition-equal-subset-sum/description/
// Partition Equal Subset Sum
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total=0;
        for(int a : nums) total+=a;
        if (total % 2 != 0) return false;
        total = total/2;
        Boolean[][] dp = new Boolean[n][total+1];
        //TOP DOWN APPROACH
        
        return recursion(0,0,total,nums,n,dp);
        
    }
    public boolean recursion(int index, int sum , int total , int[] nums,int n, Boolean[][] dp){
        if(sum == total) return true;
        if(index >= n || sum > total)  return false;
        if(dp[index][sum] != null) return dp[index][sum];
        //consider in sum1
        boolean take1 =recursion(index+1 , sum+ nums[index],total, nums,n ,dp);

        //consider in sum2
        boolean take2 = recursion(index+1, sum, total, nums ,n,dp);
        dp[index][sum] = take1 || take2;
        return take1 || take2;

    }
}