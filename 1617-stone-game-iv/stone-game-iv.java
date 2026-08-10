class Solution {
    List<Integer> t = new ArrayList<>();
    public boolean winnerSquareGame(int n) {
       for(int i = 0; i <= n; i++) {
            t.add(-1);
        }
        return solve(n);
    }

    boolean solve(int n){
        if(n == 0) return false;

        if(t.get(n) != -1){
            return t.get(n) == 1;
        }
        for(int k = 1; k * k <= n; k++){
            if(solve(n - (k*k)) == false){
                t.set(n, 1);
                return true;
            }
        }
        t.set(n, 0);
        return  false;
    }
}