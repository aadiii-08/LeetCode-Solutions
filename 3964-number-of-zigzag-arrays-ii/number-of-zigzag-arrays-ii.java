class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1; // number of distinct values
        int sz = k * 2;    // states: (value_index, direction)
        // state index: val_idx * 2 + dir
        // dir=0: arrived going UP (prev < curr) → next must go DOWN
        // dir=1: arrived going DOWN (prev > curr) → next must go UP

        // Build transition matrix
        long[][] mat = new long[sz][sz];
        for (int vi = 0; vi < k; vi++) {
            for (int d = 0; d < 2; d++) {
                int from = vi * 2 + d;
                for (int ui = 0; ui < k; ui++) {
                    if (d == 0 && ui < vi) {        // came up, must go down: u < v
                        int to = ui * 2 + 1;
                        mat[to][from] = 1;
                    } else if (d == 1 && ui > vi) { // came down, must go up: u > v
                        int to = ui * 2 + 0;
                        mat[to][from] = 1;
                    }
                }
            }
        }

        // Initial state vector after placing 2 elements (need at least one transition)
        // For each pair (v, u) with v != u:
        //   if v < u → state (u_idx, dir=0)
        //   if v > u → state (u_idx, dir=1)
        long[] vec = new long[sz];
        for (int vi = 0; vi < k; vi++) {
            for (int ui = 0; ui < k; ui++) {
                if (vi < ui) vec[ui * 2 + 0] = (vec[ui * 2 + 0] + 1) % MOD;
                if (vi > ui) vec[ui * 2 + 1] = (vec[ui * 2 + 1] + 1) % MOD;
            }
        }

        // Apply matrix (n-2) times to go from 2 elements to n elements
        long[][] result = matpow(mat, n - 2);
        long[] finalVec = matvec(result, vec);

        long ans = 0;
        for (long x : finalVec) ans = (ans + x) % MOD;
        return (int) ans;
    }

    long[][] matmul(long[][] A, long[][] B) {
        int sz = A.length;
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    long[][] matpow(long[][] M, long p) {
        int sz = M.length;
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1; // identity
        while (p > 0) {
            if ((p & 1) == 1) result = matmul(result, M);
            M = matmul(M, M);
            p >>= 1;
        }
        return result;
    }

    long[] matvec(long[][] M, long[] v) {
        int sz = v.length;
        long[] res = new long[sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++)
                res[i] = (res[i] + M[i][j] * v[j]) % MOD;
        return res;
    }
}