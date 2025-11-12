// https://leetcode.com/problems/is-graph-bipartite/description/
// 785. Is Graph Bipartite?
class Solution {
    public boolean isBipartite(int[][] graph) {
        //dfs + coloring approach
        int n= graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int []e : graph){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i=0;i<e.length;i++){
                curr.add(e[i]);

            }
            adj.add(curr);
        }
        int[] colors = new int[adj.size()];
        Arrays.fill(colors,-1);
        //iterating on adj
        for(int i=0;i<adj.size();i++){
            if(colors[i] == -1){
                if( dfs(i , 0 , colors , adj) == false) return false;
            }            
        }
        return true;

        
    }
    private boolean dfs(int node , int col , int[] colors , ArrayList<ArrayList<Integer>> adj){
        colors[node] = col; //color the node

        for(int i : adj.get(node)){  //iterate on the node
            if(colors[i] == -1){
                if( dfs ( i , 1-col , colors , adj) ==  false) return false; // recursive boolean return 
                //*"(1-col)"* will toggle the color itself)
            }
            else if ( colors[i] ==  col) return false; // return false if the adj node is already colored with the same color
        }
        return true; // return true when colored succesfull

        
    }
}