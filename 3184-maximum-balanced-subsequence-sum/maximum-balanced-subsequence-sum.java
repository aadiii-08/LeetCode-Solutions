// recursion + memo (get tle)

// class Solution {
//     Map<String, Long> map = new HashMap<>();
//     public long maxBalancedSubsequenceSum(int[] nums) {
//         long max = Integer.MIN_VALUE;
//         for(int num : nums){
//             max = Math.max(max, num);
//         }

//         if(max <= 0) return max;

//         return solve(-1, 0, nums);
//     }

//     long solve(int prev, int i, int[] nums){
//         if(i >= nums.length){
//             return 0;
//         }

//         String key = i + "_" + prev;

//         if(map.containsKey(key)){
//             return map.get(key);
//         }

//         long taken = Integer.MIN_VALUE;

//         if(prev == -1 || nums[i] - i >= nums[prev] - prev){
//             taken = nums[i] + solve(i, i + 1, nums);
//         }

//         long not_taken = solve(prev, i + 1, nums);

//         long result = Math.max(taken, not_taken);
//         map.put(key, result);

//         return result;
//     }
// }



// bottom up(get tle)
// class Solution {
//     public long maxBalancedSubsequenceSum(int[] nums) {
//         int n = nums.length;
//         long max = Integer.MIN_VALUE;
//         for(int num : nums){
//             max = Math.max(max, num);
//         }

//         if(max <= 0) return max;

//         long[] dp = new long[n];
//         for(int i = 0; i < n; i++){
//             dp[i] = nums[i];
//         }

//         long maxSum = Integer.MIN_VALUE;
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[i] - i >= nums[j] - j){
//                     dp[i] = Math.max(dp[i], dp[j] + nums[i]);
//                     maxSum = Math.max(maxSum, dp[i]);
//                 }
//             }
//         }

//         return maxSum > max ? maxSum : max;
//     }
// }



//Approach-3 (Using Optimal LIS - Similar to Patience Sorting) - Accepted
//Time : O(nlogn)
class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = nums[i]-i;
        }
        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(nums[i]<=0){
                ans = Math.max(ans, nums[i]);
            }
            else{
                long temp = nums[i];
                if(map.floorKey(arr[i])!=null){
                    temp += map.get(map.floorKey(arr[i]));
                }
                while(map.ceilingKey(arr[i])!=null && map.get(map.ceilingKey(arr[i]))<temp){
                    map.remove(map.ceilingKey(arr[i]));
                }
                if(map.floorKey(arr[i])==null || map.get(map.floorKey(arr[i]))<temp){
                    map.put(arr[i], temp);
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}