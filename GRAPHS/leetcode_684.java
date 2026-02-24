// https://leetcode.com/problems/redundant-connection/
// Redundant Connection
class Solution {
    // BRUTE FORCE -> WHILE MAKING GRAPH IF WE FOUNT THAT ON A NODE THAT IS ALREADY PRESENT IN OUR
    // CURRENT GRAPH WE CAN REACH IT FROM SOMEWHERE WE WILL RETURN THAT EDGE
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int len = edges.length;
        for(int i=0;i<=len;i++) adj.add( new ArrayList<>());

        List<Integer>curr_edges = new ArrayList<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[]visited = new boolean[len+1];

            if(dfs(u , -1 , adj, visited)) return e;
        }
        return new int[0];
    }
    public boolean dfs(int node , int parent , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        if(visited[node]) return true;

        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(neigh == parent) continue;

            if(dfs(neigh , node , adj , visited)) return true;
        }
        return false;
        
    }
}