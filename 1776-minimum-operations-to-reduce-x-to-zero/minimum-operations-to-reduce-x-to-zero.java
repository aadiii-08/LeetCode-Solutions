class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        long target = totalSum - x;
        
        if(target < 0) return -1;

        int left = 0, right = 0;
        long sum = 0;
        int ll = -1;
        while(right < n){
            sum += nums[right];
            while(sum > target){
                sum -= nums[left];
                left++;
            }

            if(sum == target){
                ll = Math.max(ll, right - left + 1);
            }
            right++;
        }

        if(ll == -1) return -1;
        return n - ll;
    }
}