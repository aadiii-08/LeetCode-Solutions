// recursion + memo

// class Solution {
//     int[][] dp;
//     int m, n;
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         m = obstacleGrid.length;
//         n = obstacleGrid[0].length;
//         if(obstacleGrid[m - 1][n - 1] == 1) return 0;
//         dp = new int[101][101];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(0, 0, obstacleGrid);
//     }

//     int solve(int i, int j, int[][] grid){
//         if(i == m - 1 && j == n - 1){
//             return 1; // found one path
//         }

//         if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1){
//             return 0; // no path
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         int right = solve(i, j + 1, grid);
//         int down = solve(i + 1, j, grid);

//         return dp[i][j] = right + down;
//     }
// }

// bottom up
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] t = new int[101][101];

        t[0][0] = 1; //total ways to reach 0,0 to 0,0

        // for 0th col
        for (int col = 1; col < n; col++) {
            if (obstacleGrid[0][col] == 0) {
                t[0][col] = 1;
            }else{
                break;
            }
        }

        // for 0th row
        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 0) {
                t[row][0] = 1;
            }else{
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }

        return t[m - 1][n - 1];
    }
}