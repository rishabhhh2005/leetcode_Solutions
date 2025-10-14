//29. Divide Two Integers
//https://leetcode.com/problems/divide-two-integers/description/
class Solution {
    public int divide(int dividend, int divisor) {
         if (divisor == 0) throw new ArithmeticException("Division by zero");

        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        
        boolean negative = (dividend < 0) ^ (divisor < 0);

        
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long sum=0;
        while(dvd >= dvs){
            int index=0;
            while( dvd >= (dvs *(1L << index))  ){
                index++;
            }
            index--;
            dvd -= (dvs << index);
            sum += (1L << index);

        }
    
        

        return negative ? (int)-sum : (int)sum; 
        
    }
}