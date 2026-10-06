// class Solution {
//     int[][] dp;
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         dp = new int[1001][1001];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(s, 0, n - 1);
//     }

//     int solve(String s, int i, int j){
//         if(i == j){
//             return 1;
//         }else if(i > j){
//             return 0;
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         if(s.charAt(i) == s.charAt(j)){
//             return dp[i][j] = 2 + solve(s, i + 1, j - 1);
//         }else{
//             return dp[i][j] = Math.max(solve(s, i + 1, j), solve(s, i, j - 1));
//         }
//     }
// }


// approach 2
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // for length 1 it always palindrom
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int l = 2; l <= n; l++){
            for(int i = 0; i < n - l + 1; i++){
                int j = i + l - 1;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }
}