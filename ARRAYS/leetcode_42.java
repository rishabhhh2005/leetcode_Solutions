// https://leetcode.com/problems/trapping-rain-water/
// Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        int[] leftPrefixMax = new int[height.length];
        int[] rightSuffixMax = new int[height.length];
        leftPrefixMax[0] = height[0];
        rightSuffixMax[height.length-1] = height[height.length-1];

        for(int i =1 ;i< leftPrefixMax.length;i++){

            leftPrefixMax[i] = Math.max(leftPrefixMax[i-1] , height[i]);
        }
        for(int i =rightSuffixMax.length-2 ;i>=0;i--){

            rightSuffixMax[i] = Math.max(rightSuffixMax[i+1] , height[i]);
        }
        int total=0;

        for(int i=0;i<height.length;i++){
            total = total +  Math.min(leftPrefixMax[i] ,rightSuffixMax[i] ) - height[i];

        }
        return total;


    
        
    }
}