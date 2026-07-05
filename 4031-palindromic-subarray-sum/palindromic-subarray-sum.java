class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;
        int[] t = new int[2 * n + 1];

        for(int i = 0; i < n; i++){
            t[2 * i + 1] = nums[i];
        }

        int m = t.length;
        int[] p = new int[m];
        int mid = 0, right = 0;

        for(int i = 0; i < m; i++){
            if(i < right){
                int co = 2 * mid - i;
                p[i] = Math.min(right - i, p[co]);
            }
            while(i - p[i] - 1 >= 0 && i + p[i] + 1 < m && t[i - p[i] - 1] == t[i + p[i] + 1]){
                p[i]++;
            }
            if(i + p[i] > right){
                mid = i;
                right = i + p[i];
            }
        }

        long[] pre = new long[n + 1];
        for(int i = 0; i < n; i++){
            pre[i + 1] = pre[i] + nums[i];
        }

        long ms = 0;
        for(int i = 0; i < m; i++){
            if(p[i] == 0) continue;
            int l = (i - p[i]) / 2;
            int r = (i + p[i]) / 2 - 1;
            if(l >= 0 && r < n && l <= r){
                long sum = pre[r + 1] - pre[l];
                if(sum > ms) ms = sum;
            }
        }
        return ms;
    }
}