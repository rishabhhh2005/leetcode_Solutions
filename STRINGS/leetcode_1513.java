// https://leetcode.com/problems/number-of-substrings-with-only-1s/
// 1513. Number of Substrings With Only 1s

class Solution {
    public int numSub(String s) {
        if(s.length() == 0) return 0;
        
        long sum =0;
        long MOD = 1000000007;
        char[] words = s.toCharArray();
        int n = words.length;
        for(int i=0;i<n;i++){
            if(words[i] == '1'){
                long c= 0;
                while(i<n && words[i] == '1'){
                    c++;
                    i++;
                }
                sum =  (sum + ((c *(c+1) )/2 ) % MOD)% MOD;

            }
        }
        return (int)(sum % MOD);

    }
}
