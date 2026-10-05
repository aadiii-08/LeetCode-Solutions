//recursion + memo

class Solution {
    int m, n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(word1, word2, 0, 0);
    }

    int solve(String s1, String s2, int i, int j){
        if(i == m){
            return n - j;
        }else if(j == n){
            return m - i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i + 1, j + 1);
        }else{
            int insertC = 1 + solve(s1, s2, i, j + 1);
            int deletC = 1 + solve(s1, s2, i + 1, j);
            int replace = 1 + solve(s1, s2, i + 1, j + 1);

            return dp[i][j] = Math.min(insertC, Math.min(deletC, replace));
        }
    }
}