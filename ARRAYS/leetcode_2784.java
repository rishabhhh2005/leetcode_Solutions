// https://leetcode.com/problems/check-if-array-is-good/description/?envType=daily-question&envId=2026-05-20
// Check if Array is Good
class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<=1) return false;
        // get the max elem
        int max = nums[n-1];

        if(max+1 != n) return false;
        int[] compare = new int[n];
        for(int i=0;i<n-1;i++){
            compare[i] = i+1;
        }
        compare[n-2] = max;  compare[n-1] = max;

        return Arrays.equals(nums , compare);
    }
}