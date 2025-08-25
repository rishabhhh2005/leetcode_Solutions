//                                                      String Compression
//                                      https://leetcode.com/problems/string-compression/
class Solution {
    public int compress(char[] chars) {
        char[]modifiedarr = new char[chars.length];
        int index=0;
        int count=1;
        for(int i=1;i<chars.length;i++){
            if( chars[i] == chars[i-1]) count++;

            else{
                modifiedarr[index++] =chars[i-1];
                if(count>1) {
                    
                    String numstr =String.valueOf(count);
                    for(int j=0;j<numstr.length();j++){
                        modifiedarr[index] = numstr.charAt(j);
                        index=index+1;
                    }
                }
                count=1;
            }
            
        }
        
        modifiedarr[index++] = chars[chars.length - 1];
        if (count > 1) {
            String numStr = String.valueOf(count);
            for (int j = 0; j < numStr.length(); j++) {
                modifiedarr[index++] = numStr.charAt(j);
            }
        }

        for (int i = 0; i < index; i++) {
            chars[i] = modifiedarr[i];
        }
        
        return index;

        
        
    }
}