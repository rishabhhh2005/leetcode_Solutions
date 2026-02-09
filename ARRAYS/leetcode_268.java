// https://leetcode.com/problems/missing-number/
// Missing Number
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedsum = (n*(n+1))/2;
        int actualsum=0;
        for(int x : nums) actualsum+=x;
        return expectedsum - actualsum;
        
    }
}