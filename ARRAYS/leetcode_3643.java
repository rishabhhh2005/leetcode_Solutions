// https://leetcode.com/problems/reverse-submatrix/description/
// Reverse Submatrix
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(k ==1) return grid;
        int p1 = x+k-1;
        int p2 =x;

        while(p1  > p2){
            for(int a =y;  a <y+k; a++){
                int temp = grid[p1][a];
                grid[p1][a] = grid[p2][a];
                grid[p2][a] = temp;
            }
            p1--;
            p2++;
        }
        return grid;

        
    }
}