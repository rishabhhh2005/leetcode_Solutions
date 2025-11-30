// https://leetcode.com/problems/house-robber-ii/description/
// House Robber II

import java.util.*;
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(
            robLinear(nums, 0, nums.length-2), //SAME HOUSE ROBBER LOGIC BUT WE CALCULAT MAX OF 2 CASES
            //ONE WITH INLUDING  THE FIRST HOUSE
            robLinear(nums, 1, nums.length-1)
        );  //ONE WITH EXCLUDING THE FIRST HOUSE
    }

    private int robLinear(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);

        dp[start] = nums[start];
        if (start + 1 <= end) {
            dp[start+1] = Math.max(nums[start], nums[start+1]);
        }

        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[end];
    }
}
