// https://leetcode.com/problems/sum-of-subarray-ranges/
// Sum of Subarray Ranges

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumofSubarrayMaximums(nums) - sumofSubarrayMinimums(nums);
    }

    public long sumofSubarrayMaximums(int[] nums) {
        int n = nums.length;
        long res = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                count += left[stack.pop()];
            }
            left[i] = count;
            stack.push(i);
        }

        stack.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                count += right[stack.pop()];
            }
            right[i] = count;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * left[i] * right[i];
        }

        return res;
    }

    public long sumofSubarrayMinimums(int[] nums) {
        int n = nums.length;
        long res = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                count += left[stack.pop()];
            }
            left[i] = count;
            stack.push(i);
        }

        stack.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                count += right[stack.pop()];
            }
            right[i] = count;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * left[i] * right[i];
        }

        return res;
    }
}
