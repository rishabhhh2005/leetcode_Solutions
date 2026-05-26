// https://leetcode.com/problems/binary-gap/?envType=daily-question&envId=2026-05-26
// Binary Gap
class Solution {
    public int binaryGap(int n) {
        // Bit Manipulation + Sliding Window
        int max=0;
        String s = numToBinary(n);

        int ptr1 =0;
        while(ptr1 < s.length()){
            if(s.charAt(ptr1) == '1') break;
            ptr1++;
        }
        if(ptr1 == s.length()) return 0;
        int ptr2 =ptr1+1;
        while(ptr2 <s.length()){
            
            if(s.charAt(ptr2) == '1') 
            {
                max = Math.max(max , ptr2 - ptr1);
                ptr1 = ptr2;
            }
            ptr2++;
        }
        return max;      
    }
   public String numToBinary(int n) {
    if (n == 0) return "0";

    StringBuilder sb = new StringBuilder();

    while (n > 0) {
        int bit = n % 2;
        sb.append(bit);
        n = n / 2;
    }

    return sb.reverse().toString();
}
}