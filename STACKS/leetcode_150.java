// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
       

        for(String s: tokens){

             if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                // operand
                if(st.isEmpty()) break;
                int eval =0;
                int elem2 = st.pop();
                int elem1 = st.pop();
                if(s.equals("+")) eval = eval + elem1+elem2;
                if(s.equals("-")) eval = eval + elem1-elem2;
                if(s.equals("*")) eval = eval + elem1*elem2;
                if(s.equals("/")) eval = eval + elem1/elem2;
                
                st.push(eval);
            }
            else st.push(Integer.parseInt(s));
        }
        return st.pop();
        
    }
}
