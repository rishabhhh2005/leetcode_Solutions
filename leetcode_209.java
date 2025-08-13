//                                           LeetCode 209: Minimum Size Subarray Sum
//                                           https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_so_far = Integer.MAX_VALUE;

        int start=0;
        int runningsum=0;
        for(int end=0;end<nums.length;end++){
            runningsum +=nums[end];

            while(runningsum>=target){
                min_so_far = Math.min(min_so_far , end-start+1);
                runningsum = runningsum - nums[start];
                start++;
            }
        }

        return (min_so_far == Integer.MAX_VALUE)?0:min_so_far;        
    }
}