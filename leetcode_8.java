//                                      LeetCode Problem 8: String to Integer (atoi)
//                                      https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        char[]chars = s.toCharArray();
        int sum=0;
        boolean isNegative =false;
        boolean leadingzero =true;
        for(char c : chars){
            
            if(leadingzero && c==' ') continue;

            if(leadingzero && (c == '+' || c == '-')){
                isNegative = (c=='-');
                leadingzero =false;
                continue;
            }
            if( c >='0' && c<='9'){
                leadingzero = false;
                int digit = c -'0';

                if(sum > (Integer.MAX_VALUE-digit)/10){
                     return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE; //Integer overflow  check
                }

                sum = sum*10 +digit;
            }else{
                break;
            }
            

        }

        if(isNegative){
            return -sum;
        }

        return sum;
        
    }
}