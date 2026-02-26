// https://leetcode.com/problems/generate-parentheses/description/
// Generate Parentheses
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        helper(0,0,new StringBuilder(),n);
        return res;
        
    }
    public void helper(int open , int close, StringBuilder currStr, int n){
        if(currStr.length() ==  2*n){
            res.add(currStr.toString());
            return;
        }

        if(open < n) { // add open only if we have left
            currStr.append('(');
            helper(open+1, close, currStr, n);
            currStr.deleteCharAt(currStr.length()-1);
        }
        if(close < open) { // add close only if we have more open in current state
            currStr.append(')');
            helper(open, close +1 , currStr , n);
            currStr.deleteCharAt(currStr.length()-1);
        }



    }
}
