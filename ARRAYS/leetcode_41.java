// https://leetcode.com/problems/first-missing-positive/description/
// First Missing Positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        // Cyclically place elements
        int n = nums.length;
        int [] original = new int[n];        

        for(int x : nums){
            if( x>0 && x <= n)
            original[x-1] =x;
        }

        for(int i=0;i<n;i++){
            if(original[i] != i+1) return i+1;
        }
        return n+1;
    }
}