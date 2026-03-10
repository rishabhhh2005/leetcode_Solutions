// https://leetcode.com/problems/find-pivot-index/
// Find Pivot Index
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum =0;
        for(int x : nums) totalSum +=x;

        int leftSum =0;
        for(int i=0;i<nums.length;i++){
            int rightSum = totalSum - leftSum  - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
        
    }
}