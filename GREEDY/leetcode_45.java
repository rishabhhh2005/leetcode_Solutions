// https://leetcode.com/problems/jump-game-ii/
// Jump Game II
class Solution {
    public int jump(int[] nums) {

        // Greedy + Sliding Window (range based)
        int n = nums.length;
        if (n == 1) return 0;

        int l = 0;      // current window ka left boundary
        int r = 0;      // current window ka right boundary
        int jumps = 0;  // total jumps count

        // Jab tak last index cover nahi ho jaata
        while (r < n - 1) {

            int maximumRange = 0;

            // Current window [l, r] ke andar
            // sabse door tak pahunchne ka range nikaalo
            for (int x = l; x <= r; x++) {
                maximumRange = Math.max(maximumRange, x + nums[x]);
            }

            // Next window start hogi r+1 se
            l = r + 1;

            // Next window ka end hoga maximumRange
            r = maximumRange;

            // Ek jump use ho gaya
            jumps++;
        }

        return jumps;
    }
}
