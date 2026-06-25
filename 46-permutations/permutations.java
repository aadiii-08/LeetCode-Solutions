class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        bT(ans, new ArrayList<>(), nums);
        return ans;
    }
    
    private void bT(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }

            temp.add(nums[i]); // add new number

            bT(ans, temp, nums); // go back and choose another element

            temp.remove(temp.size() - 1); // remove element
        }
    }
}