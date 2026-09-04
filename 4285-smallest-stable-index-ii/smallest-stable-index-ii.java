class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];

        for(int i = 1; i < n; i++){
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        int[] stable = new int[n];
        int min = nums[n - 1];
        for(int i = n - 1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            stable[i] = max[i] - min;
        }

        for(int i = 0; i < n; i++){
            if(stable[i] <= k) return i;
        }

        return -1;
    }
}