// https://leetcode.com/problems/detect-cycles-in-2d-grid/?envType=daily-question&envId=2026-05-27
//  Detect Cycles in 2D Grid
class Solution {
    char[][] grid;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // can we come back to this index
                if (!visited[i][j] && dfs(i, j, visited, -1, -1)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, boolean[][] visited, int parentRow, int parentCol) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) return false;

        if (visited[i][j]) return true;

        visited[i][j] = true;

        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        // at every step we need move 4 directions
        if (i - 1 >= 0 &&
            !(i - 1 == parentRow && j == parentCol) &&
            grid[i][j] == grid[i - 1][j]) {
            up = dfs(i - 1, j, visited, i, j);
        }

        if (i + 1 < m &&
            !(i + 1 == parentRow && j == parentCol) &&
            grid[i][j] == grid[i + 1][j]) {
            down = dfs(i + 1, j, visited, i, j);
        }

        if (j - 1 >= 0 &&
            !(i == parentRow && j - 1 == parentCol) &&
            grid[i][j] == grid[i][j - 1]) {
            left = dfs(i, j - 1, visited, i, j);
        }

        if (j + 1 < n &&
            !(i == parentRow && j + 1 == parentCol) &&
            grid[i][j] == grid[i][j + 1]) {
            right = dfs(i, j + 1, visited, i, j);
        }

        return up || down || left || right;
    }
}