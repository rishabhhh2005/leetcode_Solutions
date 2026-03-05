// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Reverse Words in a String III
class Solution {
    public String reverseWords(String s) {
        
        StringBuilder newstr = new StringBuilder();
        int length = s.length();

        for(int i=0;i<length;i++){
            if(s.charAt(i) == ' ' ){
                int j=i-1;
                while(j>=0 && s.charAt(j)!=' '){
                    newstr.append(s.charAt(j));
                    j--;
                }newstr.append(' ');
                
            }
            
        }

        int j= length-1;
        while( j>=0 && s.charAt(j) !=' '){
            newstr.append(s.charAt(j));
            j--;

        }


        return newstr.toString();
        
        
    }
}
