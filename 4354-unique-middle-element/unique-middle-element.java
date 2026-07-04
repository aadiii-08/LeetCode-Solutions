class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int midElement = nums[n/2];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == midElement) count++;
            if(count >= 2) return false;
        }

        return true;
    }
}