// recursion + memo

class Solution {
    int[][] dp;
    int m, n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        dp = new int[101][101];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, obstacleGrid);
    }

    int solve(int i, int j, int[][] grid){
        if(i == m - 1 && j == n - 1){
            return 1; // found one path
        }

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1){
            return 0; // no path
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i, j + 1, grid);
        int down = solve(i + 1, j, grid);

        return dp[i][j] = right + down;
    }
}