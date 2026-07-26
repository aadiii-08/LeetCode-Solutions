class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int pos1 = Integer.MIN_VALUE, pos2 = Integer.MIN_VALUE, pos3 = Integer.MIN_VALUE;
        int neg1 = Integer.MAX_VALUE, neg2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int curr = nums[i];

            if(curr >= pos1){
                pos3 = pos2;
                pos2 = pos1;
                pos1 = curr;
            }else if(curr >= pos2){
                pos3 = pos2;
                pos2 = curr;
            }else if(curr > pos3){
                pos3 = curr;
            }

            if(curr <= neg1){
                neg2 = neg1;
                neg1 = curr;
            }else if(curr < neg2){
                neg2 = curr;
            }
        }

        int val1 = pos1 * pos2 * pos3;
        int val2 = neg1 * neg2 * pos1;
        return Math.max(val1 , val2);
    }
}