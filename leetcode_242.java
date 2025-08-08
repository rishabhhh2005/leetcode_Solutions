//                                          LeetCode Problem 242: Valid Anagram
//                                       https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        //we can do frequency count

        int[] count =new int[26];

        for(int i=0;i<s.length();i++){

            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int v : count){
            if(v !=0) return false;
        }
        
        return true;
        
    }
}