class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(list.size() > 0 && list.get(list.size() - 1) == nums[i]){
                list.remove(list.size() - 1);
            }else{
                list.add(nums[i]);
            }
        }

        int n = list.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}