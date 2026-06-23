//coopied to do later
class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int y = 0; y < m; y++) {
            up[y] = y;             // count of x < y
            down[y] = m - 1 - y;  // count of x > y
        }

        // Build lengths 3..n
        for (int len = 3; len <= n; len++) {
            long[] prefixUp = new long[m + 1];
            long[] prefixDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] = (prefixUp[i] + up[i]) % MOD;
                prefixDown[i + 1] = (prefixDown[i] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int y = 0; y < m; y++) {
                // Sum of down[x] for x < y
                newUp[y] = prefixDown[y];

                // Sum of up[x] for x > y
                newDown[y] = (totalUp - prefixUp[y + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}