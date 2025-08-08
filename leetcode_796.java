//                                          LeetCode Problem 796: Rotate String
//                                       https://leetcode.com/problems/rotate-string/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int n = s.length();

        for (int k = 0; k < n; k++) {
            boolean match = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt((k + i) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }
}
