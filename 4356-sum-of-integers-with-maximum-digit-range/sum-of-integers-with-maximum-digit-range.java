class Solution {
    public int maxDigitRange(int[] nums) {
        int maxR = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            maxR = Math.max(maxR, maxRange(nums[i]));
        }

        for(int i = 0; i < nums.length; i++){
            if(maxRange(nums[i]) == maxR){
                ans += nums[i];
            }
        }
        return ans;
    }

    int maxRange(int x){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(x > 0){
            int rem = x % 10;
            min = Math.min(min, rem);
            max = Math.max(max, rem);
            x /= 10;
        }

        return max - min;
    }
}