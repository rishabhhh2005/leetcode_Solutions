//                                          LeetCode 424: Longest Repeating Character Replacement
//                                          https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        char[]chars = s.toCharArray();
        int maxcount=0;
        int maxlength=0;
        int start=0;
        
        int[]freq = new int[26];
        for(int end =0; end<chars.length;end++){
            char c = chars[end];
            freq[c-'A']++;
            maxcount = Math.max(maxcount , freq[c-'A']);
            while( (end-start+1) -maxcount >k){ //shrink window
                freq[chars[start]-'A']--;
                start++;

            }
            maxlength = Math.max(maxlength , (end-start+1));

        }

        return maxlength;
        
    }
}