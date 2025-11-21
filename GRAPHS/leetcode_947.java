// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
// Most Stones Removed with Same Row or Column
class Solution {
    public int removeStones(int[][] stones) {
        //we can either solve this by Disjoint Set or By Simple DFS
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int totalcomponents=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i , visited , stones);
                totalcomponents++;
            }
        }
        return n - totalcomponents;
    }

    public void dfs(int index , boolean[]visited , int[][] stones){
        visited[index] = true;

        for(int j=0;j<stones.length;j++){
            if(!visited[j]  &&  stones[index][0] ==  stones[j][0] || stones[index][1] == stones[j][1]){
                dfs(j , visited, stones);
            }

        }
    }
}