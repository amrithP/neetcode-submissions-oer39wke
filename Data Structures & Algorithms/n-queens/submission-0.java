class Solution {
    //we are placing in each row and checking col, posdiag,negdiag

    int col = 0, posDiag = 0, negDiag = 0;  //pos /  neg \
    List<List<String>> res;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
           res = new ArrayList<>(); 
           board = new char[n][n];

           for(int i =0;i<n;i++){
              for(int j=0;j<n;j++){
                board[i][j] = '.';
              }
           }
        backtrack(0,n);  //start at row 0
        return res;
    }

    public void backtrack(int r,int n){

//filled all the rows
        if(r==n){
            List<String> copy = new ArrayList<>();

            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        //try for every column

        for(int c=0;c<n;c++){
            if((col & (1 << c)) > 0 || (posDiag & (1 << (r+c)))>0 || (negDiag & (1 <<(r-c+n)))>0){
                continue;  // it means we can place the queen 
            }
          //we can place q in these places after passing the if conditn above
            col^= (1<<c);
            posDiag^= (1<<(r+c));
            negDiag^= (1<<(r-c+n));
            board[r][c] = 'Q';

            backtrack(r+1, n); //move on to next row

            //if not found any , backtrack
             col^= (1<<c);
            posDiag^= (1<<(r+c));
            negDiag^= (1<<(r-c+n));
            board[r][c] = '.';
        }

    }
}
