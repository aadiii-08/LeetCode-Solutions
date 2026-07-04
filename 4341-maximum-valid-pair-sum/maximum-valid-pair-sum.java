class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] max = new int[n];
        max[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            max[i] = Math.max(nums[i], max[i + 1]);
        }

        for(int i = 0; i + k < n; i++){
            ans = Math.max(ans, nums[i] + max[i + k]);
        }
        
        return ans;
    }
}