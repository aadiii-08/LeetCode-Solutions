class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length - 1;
        int ans = 0;
        Arrays.sort(nums);

        int val1 = nums[0] * nums[1] * nums[n];
        int val2 = nums[n] * nums[n - 1] * nums[n - 2];
        ans = Math.max(val1 , val2);
        return ans;
    }
}