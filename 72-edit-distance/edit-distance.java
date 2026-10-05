//recursion + memo

// class Solution {
//     int[][] dp;
//     public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();
//         dp = new int[501][501];

//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(word1, word2, m, n);
//     }

//     int solve(String s1, String s2, int m, int n){
//         if(m == 0 || n == 0){
//             return m + n;
//         }

//         if(dp[m][n] != -1){
//             return dp[m][n];
//         }

//         if(s1.charAt(m - 1) == s2.charAt(n - 1)){
//             return dp[m][n] = solve(s1, s2, m - 1, n - 1);
//         }else{
//             int insertC = 1 + solve(s1, s2, m, n - 1);
//             int deletC = 1 + solve(s1, s2, m - 1, n);
//             int replaceC = 1 + solve(s1, s2, m - 1, n - 1);

//             return dp[m][n] = Math.min(insertC, Math.min(deletC, replaceC));
//         }
//     }
// }

// bottom up

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[501][501];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = i + j;
                }else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int insertC = dp[i][j - 1];
                    int deletC = dp[i - 1][j];
                    int replaceC = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insertC, Math.min(deletC, replaceC));
                }
            }
        }

        return dp[m][n];
    }
}