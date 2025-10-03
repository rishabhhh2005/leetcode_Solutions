// LeetCode 2441. Largest Positive Integer That Exists With Its Negative
// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

class Solution {
    public int findMaxK(int[] nums) {
        int max=-1;
        List<Integer> list  = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int neg = -nums[i];
            if(list.contains(neg)){
                
                max = Math.max(max  , Math.max(neg,nums[i]));
            }
            else{
                list.add(nums[i]);
            }

        }
        return max;
        
    }
}