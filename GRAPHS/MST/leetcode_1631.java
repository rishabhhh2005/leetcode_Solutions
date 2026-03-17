// https://leetcode.com/problems/path-with-minimum-effort/description/
// Path With Minimum Effort
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int nodes = m*n;

       // STEP-1 BUILD GRAPH
       ArrayList<int[]> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
            
                int u = i * m + j;

                // RIGHT
                if(j + 1 < m){
                    int v = i * m + (j + 1);
                    int w = Math.abs(heights[i][j] - heights[i][j+1]);
                    edges.add(new int[]{u, v, w});
                }

                // DOWN
                if(i + 1 < n){
                    int v = (i + 1) * m + j;
                    int w = Math.abs(heights[i][j] - heights[i+1][j]);
                    edges.add(new int[]{u, v, w});
                }
            }
        }

        // STEP 2 SORT BY EDGES
        Collections.sort(edges, (a,b) -> (a[2]-b[2]));

        DSU dsu = new DSU(nodes);
        int efforts = 0;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if(dsu.union(u, v)){
                efforts = Math.max(efforts, wt);

                //  stop when start & end connected
                if(dsu.find(0) == dsu.find(nodes - 1)){
                    return efforts;
                }
            }
        }
        return efforts;
    }
}
class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Path Compression
    public int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    // Union by Size
    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        // attach smaller tree under bigger tree
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}