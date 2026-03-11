// https://leetcode.com/problems/maximum-repeating-substring/description/
// Maximum Repeating Substring
class Solution {
    public int maxRepeating(String s1, String s2) {
        int count = 0;
        String temp = s2;

        while(s1.contains(temp)){
            count++;
            temp += s2;
        }

        return count;
    }
}