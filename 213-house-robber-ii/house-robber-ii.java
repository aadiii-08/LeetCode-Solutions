//dp + memo
// class Solution {
//     int[] dp;
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         if(n ==2) return Math.max(nums[0], nums[1]);

//         dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         int firstIdx = solve(nums, 0, n - 2);
//         Arrays.fill(dp, -1);
//         int secondIdx = solve(nums, 1, n - 1);
//         return Math.max(firstIdx, secondIdx);
//     }

//     int solve(int[] nums, int i, int n){
//         if(i > n){
//             return 0;
//         }

//         if(dp[i] != -1) return dp[i];

//         int steal = nums[i] + solve(nums, i + 2, n);
//         int skip = solve(nums, i + 1, n);

//         return dp[i] = Math.max(steal, skip);
//     }
// }



// bottom up
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n ==2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n - 1; i++){
            int steal = nums[i - 1] + ((i - 2 >= 0) ? dp[i - 2] : 0);
            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }
        int firstIdx = dp[n - 1];

        Arrays.fill(dp, 0);
        for(int i = 2; i <= n; i++){
            int steal = nums[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0);
            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }
        int secondIdx = dp[n];

        return Math.max(firstIdx, secondIdx);
    }
}