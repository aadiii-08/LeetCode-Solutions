// dp + memo
// class Solution {
//     int[] dp;
//     public int rob(int[] nums) {
//         int n = nums.length;
//         dp = new int[101];
//         Arrays.fill(dp, -1);
//         return solve(nums, 0, n);
//     }

//     int solve(int[] nums, int i, int n){
//         if(i >= n) return 0;

//         if(dp[i] != -1) return dp[i];
//         int steal = nums[i] + solve(nums, i + 2, n);
//         int skip = solve(nums, i + 1, n);
//         return dp[i] = Math.max(steal, skip);
//     }
// }

// bottom up
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n + 1];

//         dp[0] = 0;
//         dp[1] = nums[0];

//         for(int i = 2; i <= n; i++){
//             int steal = nums[i - 1] + dp[i - 2];
//             int skip = dp[i - 1];
//             dp[i] = Math.max(steal, skip);
//         }

//         return dp[n];
//     }
// }

// constant space
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int prev_prev = 0, prev = nums[0];
        for (int i = 2; i <= n; i++) {

            int steal = nums[i - 1] + prev_prev;
            int skip = prev;
            prev_prev = prev;
            prev = Math.max(steal, skip);
        }

        return prev;
    }
}