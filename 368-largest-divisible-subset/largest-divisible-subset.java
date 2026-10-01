// recursion
// class Solution {
//     List<Integer> ans = new ArrayList<>();
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         List<Integer> temp = new ArrayList<>();

//         solve(0, nums, temp, -1);
//         return ans;
//     }

//     void solve(int idx, int[] nums, List<Integer> temp, int prev){
//         if(idx >= nums.length){
//             if(temp.size() > ans.size()){
//                 ans = new ArrayList<>(temp);
//             }
//             return;
//         }

//         // take 
//         if(prev == -1 || nums[idx] % prev == 0){
//             temp.add(nums[idx]);
//             solve(idx + 1, nums, temp, nums[idx]);
//             temp.remove(temp.size() - 1);
//         }

//         // not take
//         solve(idx + 1, nums, temp, prev);
//     }
// }



// bottom up
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev_idx = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev_idx, -1);
        int last_idx = 0;
        int maxL = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        prev_idx[i] = j;
                    }

                    if(dp[i] > maxL){
                        maxL = dp[i];
                        last_idx = i;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(last_idx != -1){
            ans.add(nums[last_idx]);
            last_idx = prev_idx[last_idx];
        }

        return ans;
    }
}