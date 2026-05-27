// https://leetcode.com/problems/jump-game-iv/?envType=daily-question&envId=2026-05-27
// Jump Game IV
class Solution {
    int[] arr; 

    public int minJumps(int[] arr) {
        this.arr = arr;
        int n = arr.length;

        if (n == 1) return 0;
        // Map to store duplicate indexes for same value for future use
        Map<Integer, List<Integer>> map = new HashMap<>();

//Building Map
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
    // Since BFS gives the shortest Path
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n]; //visited so that we do not wnd up inn infinite loop

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int index = q.poll();

                if(index == n - 1) return steps;

                //At every step we have three cases

                // CASE 1
                int next = index + 1;
                if(next < n && !visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }

                // CASE 2
                int prev = index - 1;
                if(prev >= 0 && !visited[prev]){
                    visited[prev] = true;
                    q.offer(prev);
                }

                // CASE 3
                if(map.containsKey(arr[index])){
                    for(int x : map.get(arr[index])){
                        if(!visited[x]){
                            visited[x] = true;
                            q.offer(x);
                        }
                    }

                    map.remove(arr[index]);
                }
            }

            steps++;
        }

        return -1;
    }
}