//                                  LeetCode Problem 1614: Maximum Nesting Depth of the Parentheses
//                                  https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;

        char[] str = s.toCharArray();
        int maxcount=0;
        for( char c : str){

            if(c == '('){
                maxcount++;
            }
            else if( c == ')'){
                maxcount--;
            }

            max = Math.max(max , maxcount);
        } 

        return max;
        
    }
}