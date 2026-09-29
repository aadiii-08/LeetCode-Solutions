class Solution {
    int N, M, K;
    int mod = 1000000007;
    int[][][] t;
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        t = new int[51][51][101];
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(0, 0, 0);
    }

    int solve(int idx, int searchCost, int max){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        }

        if(t[idx][searchCost][max] != -1){
            return t[idx][searchCost][max];
        }

        int result = 0;
        for(int i = 1; i <= M; i++){
            if(i > max){
                result = (result + solve(idx + 1, searchCost + 1, i)) % mod;
            }else{
                result = (result + solve(idx + 1, searchCost, max)) % mod;
            }
        }

        return t[idx][searchCost][max] = result % mod;
    }
}