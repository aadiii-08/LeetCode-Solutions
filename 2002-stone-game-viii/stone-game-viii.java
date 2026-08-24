class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Convert stones[] into prefix sum array
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Base case: take all stones
        int best = stones[n - 1];

        // Process from right to left
        for (int i = n - 2; i > 0; i--) {
            best = Math.max(best, stones[i] - best);
        }

        return best;
    }
}