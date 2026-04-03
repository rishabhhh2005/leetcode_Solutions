// https://leetcode.com/problems/palindromic-substrings/description/
// Palindromic Substrings
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            // odd length palindromes (center = i)
            count += expand(s, i, i);

            // even length palindromes (center = i, i+1)
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right){
        int count = 0;

        while(left >= 0 && right < s.length() 
              && s.charAt(left) == s.charAt(right)){
            
            count++;      // palindrome mila
            left--;
            right++;
        }

        return count;
    }
}