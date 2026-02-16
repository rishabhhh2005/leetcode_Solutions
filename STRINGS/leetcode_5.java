// https://leetcode.com/problems/longest-palindromic-substring/
// Longest Palindromic Substring

class Pair{ //we will make a pair because our function will return LENGTH AND STRING
    String s;
    int len;
    Pair(String s , int len){
        this.s =s;
        this.len = len;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        int maxlen=1;
        String ans = s.substring(0,1);


        for(int i=0;i<n;i++){
            Pair odd = findMaxByexpandingAroundCenter(s,i,i);
             Pair even = findMaxByexpandingAroundCenter(s,i,i+1);

             Pair curr = (odd.len > even.len) ? odd : even;

            if(curr.len > maxlen){
                ans = curr.s;
                maxlen = curr.len;
            }
           
        }
        return ans;
        
    }
// WHAT WE ARE ACTUALLY DOING IS TO EXPAND AROUND CENTER ANF THEN CHECK  FOR IT
    public Pair findMaxByexpandingAroundCenter(String s , int left , int right){
    int n = s.length();

    while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
        left--;
        right++;
    }

    int length = right - left - 1;
    String substr = s.substring(left + 1, right);

    return new Pair(substr, length);
}

}
