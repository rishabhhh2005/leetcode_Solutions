// https://leetcode.com/problems/zigzag-conversion/description/
// ZigZag Conversion
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length();
        char[][] adj = new char[numRows][len];
        for(int i=0;i<numRows;i++){
            for( int j =0; j<len ;j++) adj[i][j] = '#';
        }

        int row =0; int col =0;
        boolean uptodown = true;
        for(char c : s.toCharArray()){
           if(row == 0) uptodown = true;
            if(row == numRows - 1) uptodown = false;
            if(uptodown){
              adj[row][col] =c;
                row++;
            }
            else{
                adj[row][col] =c;
                row--;
                col++;

            }

        }
        StringBuilder res = new StringBuilder();
   
        for(int i =0;i<adj.length;i++){
            for(int j=0;j< adj[0].length; j++){
                if((adj[i][j] == '#'))continue;
                res.append(adj[i][j]);
            }
        
        }
        return res.toString();
        
    }
}