// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
class Solution {
    int threshold;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.threshold =distanceThreshold;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
         // now we need shortest path to determine if we can reach the node within the threshold
        // ie we need  a 2d matrix
        int[][] arr = new int[n][n];
        for(int[] x : arr) Arrays.fill(x, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) arr[i][i] = 0;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            arr[u][v] = w;
            arr[v][u] =w;

            ArrayList<Integer> a1 = new ArrayList<>();
            a1.add(v); a1.add(w);
            adj.get(u).add(a1);

            ArrayList<Integer> a2 = new ArrayList<>();
            a2.add(u); a2.add(w);
            adj.get(u).add(a2);
            
        }
        //since constraints are low 
        // we can applly Floys Warshall Algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE){
                        arr[i][j] = Math.min(arr[i][j] , arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        //now 2d array contains every node to node dist
        //no inorder to get city with smallest no of cities iterate and find out
        int[] min = new int[n];
     
        for(int i=0;i<n;i++){
            int unreachables =0;
            for(int j=0;j<n;j++){
                if(i!=j && arr[i][j] <= threshold ) unreachables++;
                
            }
            min[i] = unreachables;
        }

        int ans = min[0];
        int minCity = 0;
        for(int i=0;i<n;i++){
            if( min[i] <= ans){
                minCity =i;
                ans = min[i];
            }

        }
       return minCity;

        
    }
    
}