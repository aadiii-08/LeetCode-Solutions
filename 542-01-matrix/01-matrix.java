class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        

        for(int[] row : ans){
            Arrays.fill(row , -1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];

            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if( newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && ans[newRow][newCol] == -1){
                    ans[newRow][newCol] = ans[row][col] + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return ans;
    }
}