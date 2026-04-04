// https://leetcode.com/problems/decode-the-slanted-ciphertext/?envType=daily-question&envId=2026-04-04
// Decode the Slanted Ciphertext
class Solution {
    int rows ;
    int cols;
    public String decodeCiphertext(String encodedText, int row) {
        this.rows = row;
        if(rows == 1) return encodedText;
        this.cols = encodedText.length()/rows;
        char[][] matrix = new char[rows][cols];
        encode(encodedText , matrix);
        return decode(matrix);
    }
    public void encode(String s, char[][] mat){
        int index =0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j <mat[0].length;j++){
                mat[i][j] =s.charAt(index);
                index++;
            }
        }
    }
    public String decode ( char[][] mat){
        // int total_iterations = rows + ((rows*cols) -rows)/2;

        StringBuilder sb = new StringBuilder();

        int i =0;  int j=0;
        int nextcol =1;
        while(true){
            if( i== 0 && j == cols) break;
            sb.append(mat[i][j]);
            i++; j++;
            
            if( i == rows || j==cols){
                i=0;
                j=nextcol;
                nextcol++;
            }
        }
        return sb.toString().stripTrailing();


    }
}