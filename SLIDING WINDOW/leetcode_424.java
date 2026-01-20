//  https://leetcode.com/problems/longest-repeating-character-replacement/
//  Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        // Sliding Window with 2 pointers 
        int  n =s.length();
        int left =0 ;
        int right=0;
        int maxlen =0 , maxfreq=0;
        char[] arr =s.toCharArray();
        int[] freq = new int[26];
        while(right < n){
            char c = arr[right]; // current character
            freq[c -'A']++;
            maxfreq = Math.max(maxfreq , freq[c-'A']);

            while( (right -left +1) - maxfreq > k ){ // this is fomula... think logically
                char leftchar = arr[left];
                // get left character and start shrinking window
                freq[leftchar-'A']--;
                left ++;
            }
            int windowlen = right-left+1;
            maxlen = Math.max(maxlen , windowlen);
            right++;

        }
        return maxlen;
        
    }
}