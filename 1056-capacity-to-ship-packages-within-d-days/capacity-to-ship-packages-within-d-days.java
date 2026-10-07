class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int i = max, j = sum;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(solve(nums, mid, days)){
                ans = mid;
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return ans;
    }

    boolean solve(int[] nums, int max, int days){
        int count = 1;
        int total = 0;

        for(int i = 0; i < nums.length; i++){
            if(total + nums[i] > max){
                count++;
                total = 0;
            }
            total += nums[i];
        }
        return count <= days;
    }
}