// https://leetcode.com/problems/factorial-trailing-zeroes/
// Factorial Trailing Zeroes
class Solution {
    public int trailingZeroes(int n) {
        if( n<5) return 0;
        return n/5 + trailingZeroes(n/5);

    }
}