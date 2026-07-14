class Solution {

    public int ROWS,COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int r =0;r<ROWS;r++){
            for(int c = 0; c<COLS;c++){
                if(backtrack(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int r , int c , int i){
        if(i == word.length()){
            return true;
        }

        //check if outside boundary
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(i)  || board[r][c]=='#'){
            return false;
        }
        // '#' means visited 

        board[r][c] = '#';
        boolean res = backtrack(board,word,r+1,c,i+1) ||
                      backtrack(board,word,r-1,c,i+1) ||
                      backtrack(board,word,r,c+1,i+1) ||
                      backtrack(board,word,r,c-1,i+1);
        board[r][c] = word.charAt(i);  //once tried the path , remove the # so that u can try different path

        return res;

    }
}
