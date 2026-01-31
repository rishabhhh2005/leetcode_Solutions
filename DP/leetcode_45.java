// https://leetcode.com/problems/jump-game-ii/
// Jump Game II
class Solution {

    Integer[] dp; // dp[i] = min jumps to reach end from index i

    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        dp = new Integer[n];
        return recursion(0, nums);
    }

    public int recursion(int index, int[] nums) {

        // Base: last index (or beyond) reached → no more jumps
        if (index >= nums.length - 1)
            return 0;

        // Memo check
        if (dp[index] != null)
            return dp[index];

        int minJumps = Integer.MAX_VALUE;

        //  trying  all jumps from current index
        for (int i = 1; i <= nums[index]; i++) {
            int next = recursion(index + i, nums);
            if (next != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + next); // +1 for current jump
            }
        }

        dp[index] = minJumps;
        return dp[index];
    }
}
