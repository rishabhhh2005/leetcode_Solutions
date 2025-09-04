//                                                   LeetCode 1901: Find a Peak Element II
//                                                   https://leetcode.com/problems/find-a-peak-element-ii/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[2];
        boolean flag = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int current = mat[i][j];
                int up = (i>0)? mat[i-1][j]:-1;
                int down= (i<m-1)?mat[i+1][j]:-1;
                int left = (j>0)?mat[i][j-1]:-1;
                int right =(j<n-1)? mat[i][j+1]:-1;

                if(current > up && current > down && current > left && current> right){
                    flag=true;
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        if(!flag){
            result[0] =-1;
            result[1] =-1;
        }
        return result;
        //pure brute force
        
    }
}