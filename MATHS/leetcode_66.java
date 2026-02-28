// https://leetcode.com/problems/plus-one/
// Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i=n-1;
        
        while(i >=0){
            if(digits[i] < 9){
                digits[i] = digits[i]+1;
                return digits;
            }
            else{
                digits[i] =0;
            }
            i--;
        }
        int[] res = new int[n+1];
        res[0] =1;
        for(int x=0;x<n;x++) res[x+1] = digits[x];

        return res; 
        
        
    }
    
}
