// https://leetcode.com/problems/reverse-bits/?envType=problem-list-v2&envId=oizxjoit
// Reverse Bits
class Solution {
    public int reverseBits(int n) {
        int result =0;

        for(int i=0;i<32;i++){
            result = result <<1 ; // result ke right me jagah create kro
            result |= (n &1); // insert the bit 
            n >>= 1;  // n ki righmost bit hatao

        }
        return result;    
    }
}