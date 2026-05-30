// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/?envType=daily-question&envId=2026-05-30
// Minimum Element After Replacement With Digit Sum
class Solution {
    public int minElement(int[] nums) {
        int min = nums[0];
        for(int x: nums){

            String s = String.valueOf(x);
            int currsum =0;
            for( char c: s.toCharArray()){
                currsum = currsum + Integer.parseInt(String.valueOf(c));
            }
            min = Math.min(min, currsum);
        }
        return min;
        
    }
}