class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int[] freq = new int[101];

        for(int num : nums){
            start = Math.min(start, num);
            end = Math.max(end, num);
            freq[num]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = start + 1; i < end; i++){
            if(freq[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}