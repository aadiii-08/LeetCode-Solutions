class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int freshCount = 0;
        int time = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(freshCount == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] rottenLoc = q.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                int neighbours[][] = {{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};

                for(int neighbour[] : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];

                    //out of bound and already rotten & visited
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1){ 
                        continue;
                    }

                    grid[nr][nc] = 2; // visited
                    freshCount--;
                    if(freshCount == 0) return time + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
            
            time++;
            
        }

        return -1;
    }
}