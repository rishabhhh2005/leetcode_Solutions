// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
// 2220. Minimum Bit Flips to Convert Number
class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start^goal;
        return countsetbits(n);
        
    }
    public int countsetbits(int n){
        int c=0;
        while(n>0){
            if(n%2==1) c++;
            n=n/2;
        }
        return c;
    }
}