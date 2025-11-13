// https://leetcode.com/problems/course-schedule-ii/description/
// 210. Course Schedule II

class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {

        // Lets do this Question with Both of the Topo Sorts ( BFS + DFS)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] a : pre) {
            int u = a[0]; // course
            int v = a[1]; // prerequisite
            adj.get(v).add(u);        // (v -> u)
        }

        int bit = (int)(Math.random() * 2); // // We will take a random choice btw DFS and BFS
        int[] res = new int[numCourses]; 

        if (bit == 0) {
            // ---------------- DFS WAY ----------------
            boolean[] visited = new boolean[numCourses];
            boolean[] pathVis = new boolean[numCourses];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    if (!dfs(i, adj, visited, pathVis, stack)) {
                        return new int[0]; // cycle
                    }
                }
            }

            int idx = 0;
            while (!stack.isEmpty()) res[idx++] = stack.pop();
            return res;
        }

        else {
            // ---------------- BFS WAY ----------------
            Queue<Integer> q = new LinkedList<>();
            int[] indegree = new int[numCourses];

            // fill result using BFS (Kahn)
            int filled = bfs(adj, q, indegree, numCourses, res);

            if (filled != numCourses) return new int[0]; // cycle
            return res;
        }
    }


    // ------------ DFS Topo + cycle detection ---------------
    public boolean dfs(int node, 
                       ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited,
                       boolean[] pathVis,
                       Stack<Integer> stack) {

        if (pathVis[node]) return false;   // cycle
        if (visited[node]) return true;

        visited[node] = true;
        pathVis[node] = true;

        for (int neigh : adj.get(node)) {
            if (!dfs(neigh, adj, visited, pathVis, stack))
                return false;
        }

        pathVis[node] = false;
        stack.push(node);
        return true;
    }


    // ------------ BFS (Kahn's Algorithm) -------------------
    public int bfs(ArrayList<ArrayList<Integer>> adj,
                   Queue<Integer> queue,
                   int[] indegree,
                   int numCourses,
                   int[] res) {

        // Count indegrees
        for (int i = 0; i < numCourses; i++) {
            for (int neigh : adj.get(i)) indegree[neigh]++;
        }

        // Push all 0 indegree nodes
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[index++] = curr;

            // decrease indegree of neighbors
            for (int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) queue.offer(neigh);
            }
        }

        return index; // how many nodes filled
    }
}
