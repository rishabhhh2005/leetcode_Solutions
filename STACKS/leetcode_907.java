// https://leetcode.com/problems/sum-of-subarray-minimums/description/
// Sum of Subarray Minimums
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) st1.pop();
            left[i] = st1.isEmpty() ? i + 1 : i - st1.peek();
            st1.push(i);
        }

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) st2.pop();
            right[i] = st2.isEmpty() ? n - i : st2.peek() - i;
            st2.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        }

        return (int)res;
    }
}
