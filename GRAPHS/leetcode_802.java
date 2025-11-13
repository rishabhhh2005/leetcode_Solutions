// https://leetcode.com/problems/find-eventual-safe-states/description/
// 802. Find Eventual Safe States

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //reverse the graph + toposort(with) + getsafenodes
        int n= graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++) adj.add( new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        //now we have reverse Graph
        // indegree ->  becomes outdegree
        //using topo BFS order to get all the safe nodes in queue
        Queue<Integer> q = new LinkedList<>();
        int[]indegree = new int[n];
        for(int i=0;i<adj.size();i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            for( int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
            safeNodes.add(curr);
            
        }
        
        Collections.sort(safeNodes); // because we need amswer in sorted order 
        return safeNodes;
        
        
    }
}