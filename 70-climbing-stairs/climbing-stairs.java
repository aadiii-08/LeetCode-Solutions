// simple recursion get tle
// class Solution {
//     public int climbStairs(int n) {
//         return solve(n);
//     }

//     int solve(int n){
//         if(n < 0){
//             return 0;
//         }

//         if(n == 0){
//             return 1;
//         }

//         int oneStep = solve(n - 1);
//         int twoStep = solve(n - 2);
//         return oneStep + twoStep;
//     }
// }


// dp + memoization
class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[46];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    int solve(int n){
        if(n < 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int oneStep = solve(n - 1);
        int twoStep = solve(n - 2);
        return dp[n] = oneStep + twoStep;
    }
}