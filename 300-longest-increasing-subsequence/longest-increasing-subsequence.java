// dp + memo

// class Solution {
//     int n;
//     int[][] dp;
//     public int lengthOfLIS(int[] nums) {
//         n = nums.length;
//         dp = new int[n+1][n+1];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(nums, 0, -1);
//     }

//     int solve(int[] nums, int i, int p){
//         if(i >= n) return 0;

//         if(p != -1 && dp[i][p] != -1){
//             return dp[i][p];
//         }

//         int take = 0;
//         if(p == -1 || nums[p] < nums[i]){
//             take = 1 + solve(nums, i + 1, i);
//         }

//         int skip = solve(nums, i + 1, p);

//         if(p != -1){
//             dp[i][p] = Math.max(take, skip);
//         }

//         return Math.max(take, skip);
//     }
// }


// bottom up 

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int ans = 1;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         for(int i = 1; i < n; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[j] < nums[i]){
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                     ans = Math.max(ans, dp[i]);
//                 }
//             }
//         }

//         return ans;
//     }
// }



//Approac-4 (Using concept of Patience Sorting (O(nlogn))
//T.C : O(nlogn)
// S.C : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size())
                sorted.add(nums[i]); // greatest: so insert it
            else
                sorted.set(index, nums[i]); // replace
        }

        return sorted.size();
    }

    private int binarySearch(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }
}