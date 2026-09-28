// recursion + memo
class Solution {
    int n;
    int[][] dp;
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        return solve(words, 0, -1);
    }

    int solve(String[] words, int i, int p){
        if(i >= n){
            return 0;
        }

        if(p != -1 && dp[i][p] != -1){
            return dp[i][p];
        }

        int take = 0;
        if(p == -1 || isPrec(words[p], words[i])){
            take = 1 + solve(words, i + 1, i);
        }

        int skip = solve(words, i + 1, p);

        if(p != -1){
            dp[i][p] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    boolean isPrec( String prev, String curr){
        if(prev.length() + 1 != curr.length()) return false;
        int i = 0, j = 0;
        while(i < prev.length() && j < curr.length()){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i == prev.length();
    }
}