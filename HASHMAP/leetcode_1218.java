// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
// Longest Arithmetic Subsequence of Given Difference
class Solution {
    int max = Integer.MIN_VALUE;
    public int longestSubsequence(int[] nums, int d) {
        int n = nums.length;
        if(n == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums ){
            int prev = num - d;
            int currLen = map.getOrDefault(prev, 0) + 1;
            map.put(num, currLen);
            max = Math.max(max, currLen);
        }
        return max;
    }
}