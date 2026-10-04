// class Solution {
//     public boolean checkValidString(String s) {
//         int star = 0;
//         int count = 0;

//         for(int i = 0; i < s.length(); i++){
//             char ch = s.charAt(i);

//             if(ch == '('){
//                 count++;
//             }else if(ch == ')'){
//                 count--;
//             }else{
//                 star++;
//             }

//             if(count + star < 0){
//                 return false;
//             }
//         }

//         return count == 0 || count + star == 0 || count - star == 0;
//     }
// }

class Solution {
    int[][] dp;
    int n;

    public boolean checkValidString(String s) {
        n = s.length();
        dp = new int[101][101];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s);
    }

    public boolean solve(int i, int open, String s) {
        if (open < 0) {
            return false;
        }

        if (i == n) {
            return open == 0;
        }

        if (dp[i][open] != -1) {
            return dp[i][open] == 1;
        }

        boolean isValid = false;
        if (s.charAt(i) == '(') {
            isValid |= solve(i + 1, open + 1, s);
        } else if (s.charAt(i) == '*') {
            isValid |= solve(i + 1, open + 1, s);
            isValid |= solve(i + 1, open, s);
            if (open > 0) {
                isValid |= solve(i + 1, open - 1, s);
            }
        } else {
            if (open > 0) {
                isValid |= solve(i + 1, open - 1, s);
            }
        }

        dp[i][open] = isValid  ? 1 : 0;
        return isValid;
    }
}