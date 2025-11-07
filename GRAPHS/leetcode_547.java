// https://leetcode.com/problems/number-of-provinces/
// Number of provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count=0;

        for(int node =0;node<n;node++){
            if(!visited[node]){
                dfs(isConnected ,visited ,node);
                count++;
            }
        } 
        return count;       
    }

    public void dfs (int[][] isConnected , boolean[] visited , int node){
        visited[node] = true;
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
            if (isConnected[node][neighbour] == 1 && !visited[neighbour]) {
                dfs(isConnected, visited, neighbour);
            }
        }
    }
}