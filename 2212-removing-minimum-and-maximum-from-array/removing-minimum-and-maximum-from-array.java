class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        // Make minIdx the smaller index
        if (minIdx > maxIdx) {
            int temp = minIdx;
            minIdx = maxIdx;
            maxIdx = temp;
        }

        // Both from left
        int left = maxIdx + 1;

        // Both from right
        int right = n - minIdx;

        // One from left, one from right
        int both = (minIdx + 1) + (n - maxIdx);

        return Math.min(left, Math.min(right, both));
    }
}