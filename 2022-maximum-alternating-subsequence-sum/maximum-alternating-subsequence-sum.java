class Solution {
    int n;
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, nums, true);
    }

    long solve(int idx, int[] nums, boolean flag){
        if(idx >= n) return 0;

        if(dp[idx][flag ? 1 : 0] != -1){
            return dp[idx][flag ? 1 : 0];
        }

        long skip = solve(idx + 1, nums, flag);
        long val = nums[idx];
        if(flag == false) val = -val;
        long take = solve(idx + 1, nums, !flag) + val;

        return dp[idx][flag ? 1 : 0] = Math.max(skip, take);
    }
}