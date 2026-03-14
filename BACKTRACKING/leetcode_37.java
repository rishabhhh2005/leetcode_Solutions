// https://leetcode.com/problems/sudoku-solver/description/
// Sudoku Solver
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board); 
    }

     public static boolean solve(char[][] sudoku){
        //trying every possible way
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j] == '.'){
                    for(int num=1;num<=9;num++){
                        if(isSafe(num, i,j, sudoku)){
                            sudoku[i][j] =(char) (num + '0');  //place
                            if(solve(sudoku)) return true;   // recurse
                            sudoku[i][j] = '.';  // backtrack
                        }
                    }
                    return false; // no number worked
                }
                
            }
        }
        return true;
        // at the end whole sudoku will be filled
        
    }

   

    public static boolean isSafe(int num , int row, int col , char[][] sudoku){
        // we have to check 3 conditions 
        //number must not be in same row
        for(int j=0;j<9;j++){
            if(sudoku[row][j] ==(char) (num + '0')) return false;
        }

        //number must not be in same column
        for(int i=0;i<9;i++){
            if(sudoku[i][col] == (char) (num + '0')) return false;
        }

        //number must not be in same 3x3 inside grid
        // to get the start row and start col.. we use formula
        int startrow = (row/3)*3;
        int startcol =(col/3)*3;

        for(int i =startrow;i<startrow+3;i++){
            for(int j= startcol; j<startcol+3;j++){
                if(sudoku[i][j] ==(char) (num + '0')) return false;
            }
        }

        return true; // safe to place

    }

}