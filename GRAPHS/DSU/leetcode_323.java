// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Number of Connected Components in an Undirected Graph
class DSU{
    int[] parent;
    int[] rank;

    public DSU(int n){
        parent  = new int[n+1];
        rank = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i] = 0;
        }
    }

        public int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x , int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return false;

            if(rank[px] > rank[py]) parent[py] = px;
            else if (rank[py] > rank[px]) parent[px] = py;
            else{
                parent[py]= px;
                rank[px]++;

            }
            return true;
        }
    
}
class Solution {
    public int countComponents(int n, int[][] edges) {
       
        int cnt=n; // assume at first that all nodes are diff components
        DSU dsu = new DSU(n);
        for(int[]e : edges){
            int u = e[0];
            int v = e[1];
        // if successfull union -> that means they are in diff component 
            if(dsu.union(u,v) == true) cnt--;
        }
        return cnt;

    }
}
