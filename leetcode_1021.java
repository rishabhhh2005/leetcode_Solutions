//                                      LeetCode Problem 1021: Remove Outer Parentheses
//                                      https://leetcode.com/problems/remove-outer-parentheses/

class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder result =new StringBuilder();
        char[] mystr = s.toCharArray();
        int countleft =0;
        int countright=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<mystr.length;i++){
            
            char curr = mystr[i];
            
            if(curr == '('){
                sb.append('(');
                countleft++;

            }
            else{
                sb.append(')');
                countright++;
            }
            if(countleft==countright){
                //first part extracted
                result.append(decompose(sb.toString()));
                countleft=0;
                countright=0;
                 sb.setLength(0);
            }
            
        }

        return result.toString();
        
    }

    public String decompose(String s){
        StringBuilder newstr = new StringBuilder();
        int len = s.length();
        for(int i=1;i<len-1;i++){
            newstr.append(s.charAt(i));

        }

        return newstr.toString();

    }
}