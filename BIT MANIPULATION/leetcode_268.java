// https://leetcode.com/problems/missing-number/submissions/1913177602/
// Missing Number
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //Lets try to do this by BIT MANIPULATION
        //We will take XOR as we know XOR cancels 2 same numbers
        //We will take a running XOR and at the last the Number which is missing will be left
        int xor=0;
        for(int i=0;i<=n;i++) xor ^=i;

        for(int x : nums) xor ^=x;
        return xor;
        
    }
}