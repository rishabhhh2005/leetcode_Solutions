//                                                  LeetCode 383: Ransom Note
//                                                  https://leetcode.com/problems/ransom-note/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        
        char[]mags = magazine.toCharArray();

        for(char c : mags){
            freq[c-'a']++;
        }

        char[]rans = ransomNote.toCharArray();

        for(char c : rans){
            freq[c-'a']--;
            if(freq[c-'a'] <0) return false;
        }

        return true;
        
    }
}