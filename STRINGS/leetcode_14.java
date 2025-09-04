//                                          LeetCode Problem 14: Longest Common Prefix
//                                       https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        String tomatch = strs[0];
        StringBuilder  result = new StringBuilder();
        int min_match =tomatch.length();

        for(int i=1;i<len;i++){
            int start=0;
            String curr_str = strs[i];
            while(start<tomatch.length() && start < curr_str.length() && curr_str.charAt(start) == tomatch.charAt(start)){
                start++;
            }
            min_match = Math.min(min_match , start);


        }
        for(int i=0;i<min_match;i++){
            result.append(tomatch.charAt(i));
        }

        return result.toString();
        
        
    }
}