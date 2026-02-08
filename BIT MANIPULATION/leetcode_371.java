// https://leetcode.com/problems/sum-of-two-integers/
// Sum of Two Integers
class Solution {
    public int getSum(int a, int b) {

        // x me sum store hoga bina carry ke (XOR add karta hai)
        int x = a ^ b;

        // y me carry store hoga (AND se carry milta hai, <<1 se next bit pe shift)
        int y = (a & b) << 1;

        // jab tak carry bacha hai, tab tak add karte raho
        while (y != 0) {

            // temp = new sum without carry
            int temp = x ^ y;

            // naya carry nikaal rahe hain aur left shift kar rahe hain
            y = (x & y) << 1;

            // x ko update kar diya with new sum
            x = temp;
        }

        // final answer x me hai
        return x;
    }
}
