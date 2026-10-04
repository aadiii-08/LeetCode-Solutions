// recursion + memo
// class Solution {
//     int[][] dp;
//     int n;

//     public boolean checkValidString(String s) {
//         n = s.length();
//         dp = new int[101][101];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(0, 0, s);
//     }

//     public boolean solve(int i, int open, String s) {
//         if (open < 0) {
//             return false;
//         }

//         if (i == n) {
//             return open == 0;
//         }

//         if (dp[i][open] != -1) {
//             return dp[i][open] == 1;
//         }

//         boolean isValid = false;
//         if (s.charAt(i) == '(') {
//             isValid |= solve(i + 1, open + 1, s);
//         } else if (s.charAt(i) == '*') {
//             isValid |= solve(i + 1, open + 1, s);
//             isValid |= solve(i + 1, open, s);
//             if (open > 0) {
//                 isValid |= solve(i + 1, open - 1, s);
//             }
//         } else {
//             if (open > 0) {
//                 isValid |= solve(i + 1, open - 1, s);
//             }
//         }

//         dp[i][open] = isValid  ? 1 : 0;
//         return isValid;
//     }
// }



 
//bottom up
// class Solution {
//     public boolean checkValidString(String s) {
//         int n = s.length();
//         boolean[][] t = new boolean[n + 1][n + 1];
//         t[n][0] = true;

//         for(int i = n - 1; i >= 0; i--){
//             for(int open = 0; open < n; open++){
//                 boolean isValid = false;
//                 char ch = s.charAt(i);

//                 if(ch == '*'){
//                     isValid |= t[i + 1][open + 1];
//                     if(open > 0){
//                         isValid |= t[i + 1][open -1];
//                     }
//                     isValid |= t[i + 1][open];
//                 }else if(ch == '('){
//                     isValid |= t[i + 1][open + 1];
//                 }else{
//                     if(open > 0){
//                         isValid |= t[i + 1][open - 1];
//                     }
//                 }
//                 t[i][open] = isValid;
//             }
//         }

//         return t[0][0];
//     }
// }




// using stack
// class Solution {
//     public boolean checkValidString(String s) {
//         int n = s.length();
//         Stack<Integer> st = new Stack<>();
//         Stack<Integer> star = new Stack<>();
//         // int star = 0;

//         for(int i = 0; i < n; i++){
//             char ch = s.charAt(i);

//             if(ch == '*'){
//                 star.push(i);
//             }else if(ch == '('){
//                 st.push(i);
//             }else{
//                 if(!st.isEmpty()){
//                     st.pop();
//                 }else if(!star.isEmpty()){
//                     star.pop();
//                 }else{
//                     return false;
//                 }
//             }
//         }

//         while (!st.isEmpty() && !star.isEmpty()) {
//             if (st.peek() > star.peek()) {
//                 return false;
//             }
//             st.pop();
//             star.pop();
//         }

//         return st.isEmpty();
//     }
// }



//T.C : O(n)
//S.C :O(1)

class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }
                
            if (open < 0) {
                return false;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                close++;
            } else {
                close--;
            }
            
            if (close < 0) {
                return false;
            }
        }
        
        return true;
    }
}