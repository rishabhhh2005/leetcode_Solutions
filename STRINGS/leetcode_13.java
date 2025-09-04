//                                  LeetCode Problem 13: Roman to Integer
//                                  https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < roman.length; i++) {
          
            if (i < roman.length - 1 && valueOf(roman[i]) < valueOf(roman[i + 1])) {
                sum -= valueOf(roman[i]);
            } else {
                sum += valueOf(roman[i]);
            }
        }
        
        return sum;
    }

    public int valueOf(char c) {
        switch (c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }
}
