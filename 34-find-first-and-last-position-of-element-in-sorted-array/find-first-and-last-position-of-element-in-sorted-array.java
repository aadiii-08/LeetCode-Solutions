class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                int i = mid;
                low = 0;
                while(low <= i){
                    int midB = low + (i - low) / 2;
                    if(nums[midB] == target){
                        i = midB - 1;
                    }else{
                        low = midB + 1;
                    }
                }
                ans[0] = low;

                int j = mid;
                high = nums.length - 1;
                while(j <= high){
                    int midL = j + (high - j) / 2;
                    if(nums[midL] == target){
                        j = midL + 1;
                    }else{
                        high = midL - 1;
                    }
                }
                ans[1] = high;
                
                return ans;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }

        return new int[]{-1, -1};
    }
}