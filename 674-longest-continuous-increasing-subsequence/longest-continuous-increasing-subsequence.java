class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int currMax = 1;

        for(int i = 1; i < n; i++){
            if(nums[i - 1] < nums[i]){
                currMax++;
            }else{
                maxLen = Math.max(maxLen, currMax);
                currMax = 1;
            }
        }
        maxLen = Math.max(maxLen, currMax);

        return maxLen;
    }
}