class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char [][] board){
        int n = board.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(int val = 1;val<=9;val++){
                        if(issafe(i,j,board,val)){
                        board[i][j] = (char) (val + '0');
                        boolean nextsoln = solve(board);
                        if(nextsoln) return true;
                        else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean issafe(int row,int col,char [][] board,int val){
       char ch = (char) (val + '0');
       for(int i=0;i<board.length;i++){
        if(board[row][i]==ch) return false;
        if(board[i][col]==ch) return false;
        if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch) return false;
       }
       return true;
    }
}