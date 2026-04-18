// https://leetcode.com/problems/mirror-distance-of-an-integer/
// Mirror Distance of an Integer
class Solution {
    public int mirrorDistance(int n) {

        int  rev = reverse(n);
        return Math.abs(n - rev);
        
    }
    public int reverse(int n){
        int sum =0;
        while (n >0){
            int digit = n%10;
            sum = sum*10 + digit;
            n = n/10;
        }
        return sum;

    }
}