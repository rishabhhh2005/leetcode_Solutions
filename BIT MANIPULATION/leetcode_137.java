// https://leetcode.com/problems/single-number-ii/description/
// 137. Single Number II
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i+=3){
            if(i == nums.length-1 || nums[i] != nums[i-1]){
                return nums[i-1];

            }
        }
        return nums[nums.length-1];
        
    }
}