// https://leetcode.com/problems/cyclically-rotating-a-grid/?envType=daily-question&envId=2026-05-09
// Cyclically Rotating a Grid
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        if( k ==0) return grid;
        int m = grid.length;
        int n = grid[0].length;

       int[][] res = new int[m][n];
    // we can directly solve this by one by one filling every element
    // the idea is 
   // consider each layer as an array and fill accordingly
   // the number of layers we will have will be half the number of columns

        int layers = (Math.min(m,n))/2;
        int stR=0;         int stC=0;    int endR=m-1;      int endC= n-1;
        while(layers -- >0){
            ArrayList<Integer> curr = new ArrayList<>();
            // top row
            for(int x=stC;x<=endC;x++) curr.add(grid[stR][x]);

            //right most column
            for(int x=stR+1;x<=endR;x++) curr.add(grid[x][endC]);

            // bottom row reverse
            for(int x = endC-1;x>=stC;x--) curr.add(grid[endR][x]);
            
            //left most column
            for(int x= endR-1;x>stR;x--) curr.add(grid[x][stC]);


        // Now we need to rotate thw ArrayList by k
            int shift = k % curr.size();
            Collections.rotate(curr , -shift);


        // Now just fill in same order
        int p=0;
            // top row
            for(int x=stC;x<=endC;x++) res[stR][x] = curr.get(p++);

            //right most column
            for(int x=stR+1;x<=endR;x++) res[x][endC] = curr.get(p++);

            // bottom row reverse
            for(int x = endC-1;x>=stC;x--) res[endR][x] = curr.get(p++);
            
            //left most column
            for(int x= endR-1;x>stR;x--) res[x][stC] = curr.get(p++);

            // Change Boundaries after every iteration
            stR++; stC++;  endR--; endC--;    
        }
        return res;
    }
}