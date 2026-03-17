// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// Minimum Cost to Connect All Points

       //--- KRUKSAL APPROACH-------// 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //first we need to make an edge [u,v,w] and connect every point first to make a graph
        ArrayList<int[]> edges = new ArrayList<>();
        int prev=1;
        int curr =2;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                   
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int w = Math.abs(x1-x2)+ Math.abs(y1-y2);

                edges.add(new int[]{i,j,w});
    
            }
            
         } // builded the graph
        // now we need to apply kruksal algo to get minimum spanning tree which will give us cost
        return getMinCost(edges, n);
        
    }
    public int getMinCost(ArrayList<int[]> edges, int n){
        int cost = 0;
        ///sort on the basis of edge weight
        Collections.sort(edges,(a,b)->a[2]-b[2]);

        //now just  iterate and add weights until we reach N-1 while makeing sure we dont reach a cycle
        int edg =0;
        DSU dsu = new DSU(n);
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if(dsu.union(u,v) == false) continue;
            else{
                // connect this edges
                cost +=wt;
                edg++;
                if(edg ==  n-1) break;
            }
        }
        return cost;

    }
}
class DSU{
    int[] parent ;
    int[] size;
    public DSU(int n ){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i =0;i<=n;i++) parent[i] =i;
        for(int i=0;i<=n;i++) size[i]=1;
    }
    public int find(int x){
        if(parent[x] ==  x) return x;
        return parent[x] = find(parent[x]); // path compression
    }
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return false;

        if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
        }
        else{
            parent[py] = px;
            size[px] += size[py];
        }
        return true;
    }

}


//--- PRIMS APPROACH-------//
class Solution { //  SOLVING THIS WITH PRIM'S ALGORITHM WHICH IS BETTER THAN KRUKSAL IN TERMS OF TIME COMPLEXITY
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //first we need to make an adj list and connect every point first to make a graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
      
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                   
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int wt = Math.abs(x1-x2)+ Math.abs(y1-y2);

                adj.get(i).add(new int[]{j, wt});
                adj.get(j).add(new int[]{i, wt});
    
            }
            
         } // builded the graph
        // now we need to apply PRIMS algo to get minimum spanning tree which will give us cost
        return getMinCost(adj, n);
        
    }
    public int getMinCost(ArrayList<ArrayList<int[]>> adj, int n){
        
        // we use boolean array + MinHeap
        // push every neigh node with smallest weight greedily and maintaining set for not to revisit a node
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]- b[1])); // will store (node , weight to that node)
        pq.offer( new int[]{0,0});

        int cost =0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];
            if(visited[node]) continue;
            visited[node] = true;
            
            cost += wt;
            for(int[] edge : adj.get(node)){
                int neigh = edge[0];
                int  neigh_wt = edge[1];
                if(!visited[neigh]) pq.offer(new int[]{neigh , neigh_wt});
            }

        }
        return cost;
       

    }
}
