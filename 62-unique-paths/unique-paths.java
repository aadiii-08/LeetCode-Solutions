class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, m, n);
    }

    int solve(int i, int j, int m, int n){
        if(i == m - 1 && j == n - 1){
            return 1; // found one path to reach target
        }

        if(i < 0 || i >= m  || j < 0 || j >= n){
            return 0; // invalid path
        }
        if(dp[i][j] != -1){
            return dp[i][j]; // already found
        }

        int right = solve(i, j + 1, m, n);
        int down = solve(i + 1, j, m, n);
        return dp[i][j] = right + down;
    }
}