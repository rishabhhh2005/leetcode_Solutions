// https://leetcode.com/problems/rotated-digits/?envType=daily-question&envId=2026-05-09
// Rotated Digits
class Solution {
    public int rotatedDigits(int n) {
        if(n ==0 || n ==1) return 0;

        // A Number is good if  it contains
        // no 3 ,4,7
        // and either of 2 ,5,6,7
        // so in range of x to x+10 4 numbers are valid
        int count=0;
        for(int i=1;i<=n;i++ ){
            int temp = i;
            boolean valid = true;
            boolean change = false;
            while(temp >0){
                int digit = temp%10;
                if(digit ==3 || digit ==4 || digit == 7){
                    valid = false;
                    break;
                }
                if(digit ==2 || digit ==5 || digit == 6 || digit == 9){
                    change = true;
                }
                temp /=10;
            }
            if(valid && change) count++;
        }
        return count;
        
    }
}