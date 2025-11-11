// https://leetcode.com/problems/surrounded-regions/
// Surrounded Regions

class Solution {
    public void solve(char[][] board) {
        //Create a visited matrix  +  4 Boundary Traversals  +  unmark all cornered 0's and we are down
        int n = board.length;
        int m= board[0].length;
       
        boolean[][] visited = new boolean[n][m];

        for(int j=0;j<m;j++){
            if(!visited[0][j] && board[0][j] == 'O'){
                dfs(0,j , board  , visited);
            }

        }
        for(int i=0;i<n;i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0 , board  , visited);
            }

        }
        for(int j=0;j<m;j++){
            if(!visited[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1,j , board  , visited);
            }

        }
        for(int i=0;i<n;i++){
            if(!visited[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1 , board  , visited);
            }

        }
        //end me

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == true){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i , int j , char[][] board , boolean[][]visited){
       
        
        int n = board.length;
        int m = board[0].length;
         if(visited[i][j] || board[i][j] == 'X') return;
        visited[i][j] = true;

        if(i > 0 && board[i-1][j] == 'O'){
            dfs(i-1 ,j , board  , visited);
        }
        if(i+1 <n && board[i+1][j] == 'O'){
            dfs(i+1 ,j, board, visited);
        }
        if(j > 0 && board[i][j-1] == 'O'){
            dfs(i ,j-1, board, visited);
        }
        if(j+1 <m  && board[i][j+1] == 'O'){
            dfs(i , j+1,board, visited);
        }

    }
}