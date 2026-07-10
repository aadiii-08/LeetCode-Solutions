class Solution {
    public int findTheWinner(int n, int k) {
        return findWin(n, k) + 1;
    }

    int findWin(int n, int k){
        if(n == 1) return 0;

        int idx = findWin(n - 1, k);
        idx = (idx + k) % n;
        return idx;
    }
}