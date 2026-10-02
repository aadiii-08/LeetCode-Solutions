class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = i + j;
                }else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1 +  Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(m > 0 && n > 0){
            char ch1 = str1.charAt(m-1);
            char ch2 = str2.charAt(n-1);
            if(ch1 == ch2){
                sb.append(ch1);
                m--;
                n--;
            }else{
                if(dp[m-1][n] < dp[m][n-1]){
                    sb.append(ch1);
                    m--;
                }else{
                    sb.append(ch2);
                    n--;
                }
            }
        }

        while(m > 0){
            sb.append(str1.charAt(m - 1));
            m--;
        }
        while(n > 0){
            sb.append(str2.charAt(n - 1));
            n--;
        }

        sb.reverse();

        return sb.toString();
    }
}