                                    //  LeetCode 44: Wildcard Matching
                                    //  https://leetcode.com/problems/wildcard-matching/

class Solution {
    public boolean isMatch(String s, String p) {
        
        int idx1 = 0;
        int idx2 = 0;
        int starIdx = -1;
        int match = 0;

        while (idx1 < s.length()) {
            if (idx2 < p.length() && (p.charAt(idx2) == '?' || p.charAt(idx2) == s.charAt(idx1))) {
                idx1++;
                idx2++;
            } 
            else if (idx2 < p.length() && p.charAt(idx2) == '*') {
                starIdx = idx2;
                match = idx1;
                idx2++;
            } 
            else if (starIdx != -1) {
                idx2 = starIdx + 1;
                match++;
                idx1 = match;
            } 
            else {
                return false;
            }
        }

        while (idx2 < p.length() && p.charAt(idx2) == '*') {
            idx2++;
        }

        return idx2 == p.length();
    }
}
