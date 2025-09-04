//                                                LeetCode 349 : Decode String
//                                      https://leetcode.com/problems/decode-string/description/

class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result ="";
        int index=0;

        while(index < s.length()){

            char c = s.charAt(index);

            if(Character.isDigit(c)){
                int num=0;
                while(Character.isDigit(s.charAt(index))){
                    num = num*10 + (s.charAt(index)-'0');
                    index++;
                }
                counts.push(num);
            }
            else if( c == '['){
                resultStack.push(result);
                result="";
                index++;

            }

            else if( c == ']'){
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int count = counts.pop();
                for(int i=0;i<count;i++){
                    temp.append(result);
                }
                result = temp.toString();
                index++;

            }
            else{
                result +=c;
                index++;
            }
        }
        return result;
        
    }
}