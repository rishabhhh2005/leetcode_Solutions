// 52. N-Queens II
class Solution {
    int count;
    public int totalNQueens(int n) {
        count=0;

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antidiags = new HashSet<>();

        backtrack(0,cols,diags,antidiags,n);
        return count;
        
    }
    public void backtrack(int row , Set<Integer> cols , Set<Integer> diags , Set<Integer> antidiags , int n){

        if(row == n){
            count++;
            return;
        }
        for(int col = 0;col <n;col++){
            if(cols.contains(col)) continue;

            int diag = col-row;
            int antidiag = col+row;
            if(diags.contains(diag) || antidiags.contains(antidiag)) continue;
            cols.add(col);
            antidiags.add(antidiag);
            diags.add(diag);

            backtrack(row+1, cols, diags, antidiags,n);
            diags.remove(diag);
            antidiags.remove(antidiag);
            cols.remove(col);

        }
        return;
    }
}