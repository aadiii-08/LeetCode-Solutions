class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        bT(ans, new ArrayList<>(), nums, new boolean[nums.length]);

        return ans;
    }

    private void bT(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums, boolean[] flag) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue; // Skip if the current element is already used
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;  // has already been used in the current permutation

            // add new element and marked as used
            flag[i] = true;
            temp.add(nums[i]);

            bT(ans, temp, nums, flag); // go back and try another element

            // remove and marked as unused
            flag[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}