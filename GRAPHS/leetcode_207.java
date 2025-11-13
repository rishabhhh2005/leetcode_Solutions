// https://leetcode.com/problems/course-schedule/description/
// Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //We can use Topo Sort (Dfs + 2 boolean Arrays)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i< numCourses;i++) adj.add( new ArrayList<>());

        for(int []a : prerequisites){
            int u= a[0];
            int v = a[1];
            adj.get(u).add(v);
        }
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(i , adj , visited, pathVisited)) return false;
        }
        return true;
        
      
        
    }
    public boolean dfs( int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , boolean[]pathVisited){
        if( pathVisited[node]) return false;
        if(visited[node]) return true;

        visited[node]= true;
        pathVisited[node] = true;

        for(int neigh : adj.get(node)){
            if(!dfs(neigh , adj , visited, pathVisited)) return false;
        }
        pathVisited[node] = false; //backtracking
        return true;
    }
  
}