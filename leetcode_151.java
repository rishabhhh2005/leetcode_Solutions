//                                      LeetCode Problem 151: Reverse Words in a String
//                                      https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
        
    }
}