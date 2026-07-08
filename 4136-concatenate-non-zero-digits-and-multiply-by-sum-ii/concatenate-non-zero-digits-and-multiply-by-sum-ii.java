class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;
        int m = s.length();
        int[] ans = new int[n];

        //sum of all non-zero
        long[] pre = new long[m];
        pre[0] = s.charAt(0) - '0';

        for(int i = 1; i < m; i++){
            pre[i] = pre[i - 1] + s.charAt(i) - '0';
        }

        // all non-zero digit 
        long[] digit = new long[m];
        digit[0] = s.charAt(0) - '0';

        for(int i = 1; i < m; i++){
            int curr = s.charAt(i) - '0';
            if(curr == 0){
                digit[i] = digit[i - 1];
            }else{
                digit[i] = (digit[i - 1] * 10 + curr) % MOD;
            }
        }

        // count of non-zero digit
        int[] count = new int[m];
        count[0] = s.charAt(0) != '0' ? 1 : 0;

        for(int i = 1; i < m; i++){
            int curr = s.charAt(i) - '0';
            count[i] = count[i - 1] + (curr != 0 ? 1 : 0);
        }

        //// power of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 1; i <= m; i++){
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        //calculateing the value of ans
        for(int i = 0; i < n; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int startCount = (l == 0) ? 0 : count[l - 1];
            long numBefore = (l == 0) ? 0 : digit[l - 1];

            int endCount = count[r];
            int subStrLen = endCount - startCount;

            if(subStrLen == 0){
                ans[i] = 0;
                continue;
            }

            long x = (digit[r] - (numBefore * pow10[subStrLen] % MOD) + MOD) % MOD;
            long sum = pre[r] - (l == 0 ? 0 : pre[l - 1]);

            ans[i] = (int) ((x * sum) % MOD);
        }
        return ans;
    }
}