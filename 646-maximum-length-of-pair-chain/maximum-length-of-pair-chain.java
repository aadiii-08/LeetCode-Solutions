// dp + memo
// class Solution {
//     int n;
//     int[][] dp;
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
//         n = pairs.length;
//         dp = new int[n+1][n+1];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(pairs, 0, -1);
//     }

//     int solve(int[][] pairs, int i, int p){
//         if(i >= n){
//             return 0;
//         }

//         if(p != -1 && dp[i][p] != -1){
//             return dp[i][p];
//         }

//         int take = 0;
//         if(p == -1 || pairs[p][1] < pairs[i][0]){
//             take = 1 + solve(pairs, i + 1, i);
//         }

//         int skip = solve(pairs, i + 1, p);

//         if(p != -1){
//             dp[i][p] = Math.max(take, skip);
//         }

//         return Math.max(take, skip);
//     }
// }



// bottom up
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int ans = 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}