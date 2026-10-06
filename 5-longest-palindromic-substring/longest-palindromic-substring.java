class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        dp = new int[1001][1001];
        String ans = "";
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrom(s, i, j) && ans.length() < j - i + 1){
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
    boolean isPalindrom(String s, int i, int j){
        if(i > j){
            return true;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 0 ? false : true;
        }

        if(s.charAt(i) == s.charAt(j)){
            boolean result = isPalindrom(s, i + 1, j - 1);
            dp[i][j] = result ? 1 : 0;
            return result;
        }

        dp[i][j] = 0;
        return false;
    }

}