// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int p1=0;
        int p2 =n-1;

        while(p1 <p2){
            if( nums[p1] + nums[p2] ==  target) return new int[]{p1+1 , p2+1};
            else if ( nums[p1] + nums[p2] < target) p1++;
            else p2--;
        }
        
        return new int[]{0,0};
    }
}