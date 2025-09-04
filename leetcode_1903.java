//                                      LeetCode Problem 1903: Largest Odd Number in String
//                                      https://leetcode.com/problems/largest-odd-number-in-string/

class Solution {
    public String largestOddNumber(String num) {
        if(num.length() == 0) return num;
        char[]numbers = num.toCharArray();
        StringBuilder result = new StringBuilder();

        int start=-1;
        int end=numbers.length;
        for(char c : numbers){
            result.append(c);
        }

        
        for(int i=numbers.length-1 ;i>=0;i--){
            if(numbers[i]%2==1){
                //odd found
                start=i;
                break;
            }

        }

        result.delete(start+1,end);
        return result.toString();
        
    }
}