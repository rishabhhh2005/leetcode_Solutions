// https://leetcode.com/problems/redundant-connection/
// Redundant Connection
class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i] = 0;
        }
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public boolean union(int x , int y){
        int px = find(x);
        int py = find(y);
        // Agar dono ka parent same hai -> already connected (cycle)
        if(px == py) return false;

        if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else if ( rank[px] > rank[py]){
            parent[py] = px;
        }
        else{
            parent[py] =px;
            rank[px]++;
        }
        return true;

    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(dsu.union(u,v) == false){
                //cycle detected
                return new int[]{u,v}; // agar dono ke parent same h to CYCLE HAI
            }
        }
        return new int[0];
        
    }
}
