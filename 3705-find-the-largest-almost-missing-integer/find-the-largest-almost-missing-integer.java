class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int ans = Integer.MIN_VALUE;
        if(k == nums.length){
            for(int i = 0; i < nums.length; i++){
                ans = Math.max(ans, nums[i]);
            }
            return ans;
        }

        int i = 0;
        while(i + k <= nums.length){
            for(int j = i; j < k + i; j++){
                freq[nums[j]]++;
            }
            i++;
        }

        for(int j = freq.length - 1; j >= 0; j--){
            if(freq[j] == 1){
                return j;
            }
        }

        return -1;
    }
}