// https://leetcode.com/problems/word-search/
// Word Search
class Solution {
    String word;
    char[][] board;
    int m , n;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        if(word.length() == 0) return  false;
        boolean[][] visited = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,0,visited)) return true;
            }
        }
        return false;
        
    }
    public boolean dfs(int i , int j,int index ,boolean[][] visited ){

        if(index == word.length()) return true;

        if(i <0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j] != word.charAt(index) ) return false;
        boolean make = false;
        visited[i][j] = true;
        if(board[i][j] == word.charAt(index)){
           make = dfs(i-1,j,index+1,visited) ||
            dfs(i+1,j,index+1,visited) || 
            dfs(i,j+1,index+1,visited) ||
            dfs(i,j-1,index+1,visited) ;
        }
        visited[i][j] = false;
        return make;
        



    }
}