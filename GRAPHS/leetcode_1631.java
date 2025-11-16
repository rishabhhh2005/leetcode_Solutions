// https://leetcode.com/problems/path-with-minimum-effort/
// Path With Minimum Effort

class Solution {
    public int minimumEffortPath(int[][] heights) {
        //We will use Djikstra's Algorithm with Priority Queue with BFS for this Question
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // pq will sort by effort
        pq.offer(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[rows][cols];

        int[][] effort = new int[rows][cols]; // we will make an effort array to keep track of efforts
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int currEffort = curr[2];

            if (visited[i][j]) continue;
            visited[i][j] = true;

            if (i == rows - 1 && j == cols - 1) return currEffort;

            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && !visited[ni][nj]) {

                    int diff = Math.abs(heights[ni][nj] - heights[i][j]);
                    int nextEffort = Math.max(currEffort, diff);

                    if (nextEffort < effort[ni][nj]) {
                        effort[ni][nj] = nextEffort;
                        pq.offer(new int[]{ni, nj, nextEffort});
                    }
                }
            }
        }

        return effort[rows - 1][cols - 1];
    }
}
