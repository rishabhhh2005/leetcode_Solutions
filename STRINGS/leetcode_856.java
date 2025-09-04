//                                       LeetCode Problem 856: Score of Parentheses
//                                       https://leetcode.com/problems/score-of-parentheses/description/

class Solution {
    public int scoreOfParentheses(String s) {
        double score =0;
        int depth=0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                depth++;
            }
            else{
                depth--;
                if(s.charAt(i-1) =='('){
                    score += Math.pow(2,(double)depth);
                }
            }
        }
        return (int)score;
        
    }
}