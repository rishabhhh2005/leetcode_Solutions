// https://leetcode.com/problems/rotate-image/
// Rotate Image
class Solution {
    public void rotate(int[][] matrix) {
        
        //mirror +swap diagonal elems
        int n = matrix.length;
        mirror(matrix);
        for(int i=0;i<n;i++){
            // i ==0   j== n-1       i==1   j == n-1-i           i==2    j== 4-1-2
           int index=1;
            for(int j = n-i-2 ;j>=0;j--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i+index][j+index];
                matrix[i+index][j+index] = temp;
                index = index+1;
                
            }
        }

    }
    public void mirror(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            int left =0;
            int right = n-1;
            while(left < right){
                int temp =matrix[i][left] ;
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left ++;
                right--;
            }
        }
    }
}
