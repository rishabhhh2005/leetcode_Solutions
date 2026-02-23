// https://leetcode.com/problems/goal-parser-interpretation/
// 1678. Goal Parser Interpretation
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<command.length();i++){
             if(command.charAt(i) == 'G'){
                sb.append('G');
             }
             else if(command.charAt(i) == '('){
                if(command.charAt(i+1) == 'a'){
                    sb.append("al");
                }
                else if( command.charAt(i+1) == ')'){
                    sb.append('o');

                }
             }
        }
        return sb.toString();
        
    }
}