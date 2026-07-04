class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.'){
                    for(char d = '1'; d <= '9'; d++){
                        if(isValid(board, i, j, d)){
                            board[i][j] = d;

                            if(solve(board) == true){
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char d){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == d){
                return false;
            }

            if(board[row][i] == d){
                return false;
            }
        }

        int sr = row / 3 * 3;
        int sc = col / 3 * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[sr + i][sc + j] == d){
                    return false;
                }
            }
        }
        return true;
    }
}