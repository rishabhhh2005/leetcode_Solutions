// https://leetcode.com/problems/rotting-oranges/description/
// Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<ArrayList<ArrayList<Integer>>> q = new LinkedList<>();
        //  queue< <i,j> <time> >
        int n = grid.length;
        int m= grid[0].length;
        boolean[][]visited = new boolean[n][m];
        int ans =-1;
        int freshoranges=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] == 2){
                    ArrayList<ArrayList<Integer>> rotten =new ArrayList<>();
                    rotten.add(new ArrayList<>(Arrays.asList(i, j)));

                    rotten.add(new ArrayList<>(Arrays.asList(0)));
                    q.offer(rotten);
                    visited[i][j]= true;
                }
                 if(grid[i][j] == 1){
                    freshoranges++;
                }
            }
        }
        if(freshoranges == 0) return 0;
        while(!q.isEmpty()){
             ArrayList<ArrayList<Integer>> current = q.poll();
             int i=current.get(0).get(0);
             int j = current.get(0).get(1);
             int time =current.get(1).get(0);
             ans = Math.max(ans,time); 

             if(i-1>=0 && !visited[i-1][j] && grid[i-1][j] == 1){
                  ArrayList<ArrayList<Integer>> rotting =new ArrayList<>();
                  rotting.add(new ArrayList<>(Arrays.asList(i-1,j)));
                  rotting.add(new ArrayList<>(Arrays.asList(time+1)));
                  q.offer(rotting);
                  visited[i-1][j] =true;
             }
              if(j-1>=0 && !visited[i][j-1] && grid[i][j-1] == 1){
                  ArrayList<ArrayList<Integer>> rotting =new ArrayList<>();
                  rotting.add(new ArrayList<>(Arrays.asList(i,j-1)));
                   rotting.add(new ArrayList<>(Arrays.asList(time+1)));
                  q.offer(rotting);
                  visited[i][j-1] =true;
             }
             if(i+1<n && !visited[i+1][j] && grid[i+1][j] == 1){
                  ArrayList<ArrayList<Integer>> rotting =new ArrayList<>();
                  rotting.add(new ArrayList<>(Arrays.asList(i+1,j)));
                 rotting.add(new ArrayList<>(Arrays.asList(time+1)));
                  q.offer(rotting);
                  visited[i+1][j] =true;
             }
             if(j+1<m && !visited[i][j+1] && grid[i][j+1] == 1){
                  ArrayList<ArrayList<Integer>> rotting =new ArrayList<>();
                  rotting.add(new ArrayList<>(Arrays.asList(i,j+1)));
                   rotting.add(new ArrayList<>(Arrays.asList(time+1)));
                  q.offer(rotting);
                  visited[i][j+1] =true;
             }

            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1 && !visited[i][j]){
                    ans=-1;
                }
            }
        }
        return ans;

    }
}