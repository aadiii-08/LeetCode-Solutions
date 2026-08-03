class Solution {
    public String stoneGameIII(int[] stones) {
        int n = stones.length;
        int[] t = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            t[i] = stones[i] - t[i + 1];

            if(i + 2 <= n)
                t[i] = Math.max(t[i], stones[i] + stones[i + 1] - t[i + 2]);

            if(i + 3 <= n)
                t[i] = Math.max(t[i], stones[i] + stones[i + 1] + stones[i + 2] - t[i + 3]);

        }

        int diff = t[0];

        if(diff < 0){
            return "Bob";
        }else if(diff > 0){
            return "Alice";
        }

        return "Tie";
    }
}