// https://leetcode.com/problems/critical-connections-in-a-network/
//  Critical Connections in a Network

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());


        for(List<Integer> l : connections){
            int u= l.get(0);
            int v = l.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //now we are done with the adjacency list
        // we will be applying Tarjan's Algorithm
        // DFS + 3 ARRAYS + BACKTRACKING + TIMER

        int[] DISC = new int[n]; // keep track of the time it took to reach
        int[] LOW = new int[n]; // keep track of lowest time it took to reach
        int[] PARENT = new int[n]; // keep track of parent

        for(int i=0;i<n;i++){
            DISC[i] =-1;
            LOW[i] = -1;
            PARENT[i] = -1;
        }
        DISC[0] = 0;
        LOW[0] =0;

        boolean[]visited = new boolean[n];
        int time=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i ,time, visited , adj , DISC, LOW , PARENT, res);
            }

        }
        return res;
    }
    public void dfs( int node ,int time, boolean[]visited , ArrayList<ArrayList<Integer>> adj, int[] DISC , int[] LOW, int[] PARENT, List<List<Integer>> res){
        boolean isBackedge = false;
        visited[node] = true;
        DISC[node] = time+1;
        LOW[node] = time+1;

        for(int neigh : adj.get(node)){
            if (neigh == PARENT[node]) continue;

            if(visited[neigh] && neigh != PARENT[node]){
                // WE HAVE A BACK EDGE
                isBackedge = true;
                LOW[node] = Math.min(LOW[node], DISC[neigh]);     // we will update the lowest time of child to discovery time of parent in case of back edge
            }
            if(!visited[neigh] ){
                PARENT[neigh] = node;
                dfs( neigh , time+1, visited , adj , DISC , LOW , PARENT, res);
                
            }
            //BackTrack
            // no we will be update the low value of the current node because maybe his call found out a backedge
            LOW[node] = Math.min( LOW[node],  LOW[neigh]);

            //After update values.. Check for bridge
            if( LOW[neigh] > DISC[node]){
                res.add( new ArrayList<>(Arrays.asList(node , neigh)));
            }
            
        }
        
        
    }
}