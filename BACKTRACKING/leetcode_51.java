class Solution {
    public void backtrack(
        int row, 
        Set<Integer> cols,
        Set<Integer> diags,
        Set<Integer> antidiags,
        int n,
        List<List<String>> board,
        char[][] game
                        ){
        //base case
        if(row == n){
            // we got an answer
            List<String> ans = new ArrayList<>();
            for(char[] c : game){
                ans.add( new String(c));
            }
            board.add(ans);

            return;
        }

        for(int col=0;col<n;col++){
            if(cols.contains(col)){
                // we cannot put the queen here
                continue;
            }  
            int diag = col-row;
            int antidiag = col+row;
            if(diags.contains(diag)) continue;
            if(antidiags.contains(antidiag)) continue;
    
            cols.add(col);
            diags.add(diag);
            antidiags.add(antidiag);
            game[row][col] ='Q';
    
            backtrack(row+1, cols, diags, antidiags, n , board, game);
            // backtrack to remove and unplace the queen
            cols.remove(col);
            diags.remove(diag);
            antidiags.remove(antidiag);
            game[row][col] ='.';  
        }
        }

    public List<List<String>> solveNQueens(int n) {
        // we will track the board here
        List<List<String>> board = new ArrayList<>();

        // we will track the current occupied cols, diaggs, antodiags here 
        //(for row , 'i' is enough)
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antidiags = new HashSet<>();

        // constantly moving board
        char [][] game = new char[n][n];
        for(int  i=0;i<n;i++){
            for(int j =0;j<n ;j++){
                game[i][j] ='.';
            }
        } 
        backtrack(0,cols,diags,antidiags,n, board, game);

       return board; 
        
    }
}