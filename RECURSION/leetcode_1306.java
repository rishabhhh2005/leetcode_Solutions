// https://leetcode.com/problems/jump-game-iii/?envType=daily-question&envId=2026-05-27
// Jump Game III
class Solution {
    int[] arr;
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        // the idea is to try out all possible ways
        int n = arr.length;
        this.visited= new boolean[n]; // visited to avoid infinite recursion
        return recursion(start);
    
    }

    public boolean recursion(int index ){
        if(index <0 || index >=arr.length) return false;
        if(arr[index] == 0 ) return true;

        if(visited[index]) return false;
        // at every index we have 2 choices 
        visited[index] = true;
        // 1. move  i + arr[i]
        boolean case1 = recursion(index + arr[index]);

        // 2. move i-arr[i]
        boolean case2 = recursion(index - arr[index]);

        return case1 || case2;
    }
}