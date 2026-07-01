class Solution {
    int[][] dir = {{0,1},{0, -1},{-1, 0},{1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        Queue<int[]> q = new ArrayDeque<>();

        int[][] mat = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int val = grid.get(i).get(j);
                if(val == 1){
                    q.offer(new int[]{i, j});
                }
                mat[i][j] = val; 
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int x = curr[0], y = curr[1];

            for(int i = 0; i < 4; i++){
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if(r < 0 || r >= n || c < 0 || c >= n || mat[r][c] > 0) continue;
                mat[r][c] = mat[x][y] + 1;
                q.offer(new int[]{r, c});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        pq.offer(new int[]{mat[0][0], 0 , 0});
        mat[0][0] = -1; // visited

        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            int sfac = curr[0], x = curr[1], y = curr[2];

            if(x == n - 1 && y == n - 1){
                return sfac - 1;
            }

            for(int i = 0; i < 4; i++){
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if(r < 0 || r >= n || c < 0 || c >= n || mat[r][c] < 0) continue;
                int min = Math.min(sfac, mat[r][c]);
                pq.offer(new int[]{min, r, c});
                mat[r][c] = -1;
            }
        }

        return 0;
    }
}