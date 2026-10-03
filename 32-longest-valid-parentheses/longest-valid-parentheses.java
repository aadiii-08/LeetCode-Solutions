//using stack

// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer> st = new Stack<>();
//         st.push(-1);
//         int ans = 0;
//         for(int i = 0; i < s.length(); i++){
//             char ch = s.charAt(i);

//             if(ch == '('){
//                 st.push(i);
//             }else{
//                 st.pop();

//                 if(st.isEmpty()){
//                     st.push(i);
//                 }else{
//                     int length = i - st.peek();
//                     ans = Math.max(ans, length);
//                 }
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open = 0, close = 0;
        int ans = 0;

        // left to right
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
            }else{
                close++;
            }

            if(open < close){
                open = close = 0;
            }else if(open == close){
                ans = Math.max(ans, open + close);
            }
        }


        // right to left
        open = close = 0;
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
            }else{
                close++;
            }

            if(open > close){
                open = close = 0;
            }else if(open == close){
                ans = Math.max(ans, open + close);
            }
        }

        return ans;
    }
}