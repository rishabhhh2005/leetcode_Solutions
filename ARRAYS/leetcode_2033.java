// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
// Minimum Operations to Make a Uni-Value Grid
class Solution {
    public int minOperations(int[][] grid, int x) {
    
        int m = grid.length;
        int n = grid[0].length;
        int[]arr = new int[m*n];
        int index =0;
        int expectedremainder = grid[0][0]%x;
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                arr[index++] = grid[i][j];
                if(grid[i][j] % x != expectedremainder) return -1; // impposible condition
            }
        }
        Arrays.sort(arr);    

        // trying to convert to the middle element is always benificial
        int low =0 ;
        int high = arr.length-1;

        if (arr.length%2 == 0){
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;

            int elem1 = arr[mid1];
            int elem2 = arr[mid2];

            int minOps1 =0;  int minOps2= 0;
            for(int e : arr){
                minOps1 += Math.abs(elem1 -e) /x;
                minOps2 += Math.abs(elem2-e)/x;
            }
            return Math.min(minOps1 , minOps2);

        }
        else{
            int mid = (low + high)/2;
            int elem = arr[mid];
        
            int minOps =0;
            for(int e : arr){
                minOps += Math.abs(elem-e)/x;
            }
            return minOps;

        }

    }

    
}