class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int row = 0; row < n; row++){
            Set<Integer> set = new HashSet<>();
            for(int col = 0; col < n; col++){
                if(board[row][col] == '.') continue;
                int curr = board[row][col] - '1' + 1;
                if(set.contains(curr)){
                    return false;
                }else{
                    set.add(curr);
                }
            }
        }

        for(int col = 0; col < n; col++){
            Set<Integer> set = new HashSet<>();
            for(int row = 0; row < n; row++){
                if(board[row][col] == '.') continue;
                int curr = board[row][col] - '1' + 1;
                if(set.contains(curr)){
                    return false;
                }else{
                    set.add(curr);
                }
            }
        }
        

        for(int sr = 0; sr < 9; sr +=3){
            for(int sc = 0; sc < 9; sc += 3){

                Set<Integer> set = new HashSet<>();
                for(int row = sr; row < sr + 3; row++){
                    for(int col = sc; col < sc + 3; col++){
                        if(board[row][col] == '.') continue;
                        int curr = board[row][col] - '1' + 1;
                        if(set.contains(curr)){
                            return false;
                        }else{
                            set.add(curr);
                        }
                    }
                }
            }
        }

        return true;
    }
}