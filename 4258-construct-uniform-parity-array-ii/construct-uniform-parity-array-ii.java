class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean odd = false;

        for(int num : nums){
            if(num % 2 != 0) odd = true;

            min = Math.min(min, num);

        }
        if(min % 2 != 0 || !odd) return true;

        return false;
    }
}