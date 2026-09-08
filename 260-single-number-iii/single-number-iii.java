class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        int n = set.size();
        int[] ans = new int[n];
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                ans[idx++] = nums[i];
            }
        }

        return ans;
    }
}