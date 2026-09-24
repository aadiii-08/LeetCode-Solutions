// // dp + memoization 
// class Solution {
//     public int fib(int n) {
//         if(n <= 1) return n;
        
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return solve(n, dp);
//     }

//     int solve(int n, int[] dp){
//         if(n <= 1) return n;

//         if(dp[n] != -1) return dp[n];

//         return dp[n] = solve(n-1, dp) + solve(n-2, dp);
//     }
// }

//bottom up
// class Solution {
//     public int fib(int n) {
//         if(n <= 1) return n;

//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         dp[0] = 0;
//         dp[1] = 1;

//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }


//sc = O(1) tc = O(n)
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int a = 0, b = 1, c = 0;
        for(int i = 1; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}