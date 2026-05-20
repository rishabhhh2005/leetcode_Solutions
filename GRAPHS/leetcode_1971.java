// https://leetcode.com/problems/find-if-path-exists-in-graph/
// Find if Path Exists in Graph
class Solution {
    boolean flag = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Build Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u =e[0];  int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        // Do Dfs from Source .. if we reach destination we return True else False
        dfs(source, destination, adj, visited);
        return flag;
        
    }

    public void dfs( int node, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if( flag || visited[node]) return;
        if(node == dest) { flag = true ; return;}
        visited[node] = true;
        for(int neigh : adj.get(node)){
            dfs(neigh, dest, adj, visited);
        }
    }
}

