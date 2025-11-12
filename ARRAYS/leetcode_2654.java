// https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/
// Minimum Number of Operations to Make All Array Elements Equal to 1

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int x : nums) {
            if (x == 1) ones++;
        }
        if (ones > 0) return n - ones;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans + n - 1;
    }

    private int gcd(int a, int b) {
        if(b ==0) return a;
        return gcd(b, a%b);
    }
}