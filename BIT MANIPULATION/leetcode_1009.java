// https://leetcode.com/problems/complement-of-base-10-integer/description/
// Complement of Base 10 Integer
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int  temp=n;

        int i =0;
        while(temp > 0){
            n ^= (1 << i);
            temp >>= 1;
            i++;
        }
        return n;
        
    }
}