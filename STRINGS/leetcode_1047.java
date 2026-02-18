// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
// Remove All Adjacent Duplicates In String 

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!st.isEmpty()){
                char x = st.peek();
                if(c == x){
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }
        while(!st.isEmpty()){
            res.append(st.pop());
            
        }
        return res.reverse().toString();
        
    }
}