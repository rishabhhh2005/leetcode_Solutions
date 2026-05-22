// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2026-05-22
// Minimum Changes To Make Alternating Binary String
class Solution {
    public int minOperations(String s) {
        int len = s.length();
        // we need to try both ways 1) start from '1'   2) start from '0'
        int case1 =0;
        // start from 1

        char flag1 ='1';
        for( char c : s.toCharArray()){
            if (c != flag1) case1++;

            if(flag1 =='1') flag1 = '0';
            else flag1 = '1';
        }

        int case2 =0;
        // start from 0

        char flag2 ='0';
        for( char c : s.toCharArray()){
            if (c != flag2) case2++;

            if(flag2 =='1') flag2 = '0';
            else flag2 = '1';
        }

        return Math.min(case1 , case2);
    }
}