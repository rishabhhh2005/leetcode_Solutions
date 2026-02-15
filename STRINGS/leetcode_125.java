// https://leetcode.com/problems/valid-palindrome/
//  Valid Palindrome

class Solution {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int p1 =0;
        int p2 = str.length()-1;
      
        while(p1 <p2){
            if(str.charAt(p1) != str.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
}