class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr == '('){
                st.push(i);
                ans = Math.max(ans, st.size());
            }
            if(curr == ')') st.pop();
        }

        return ans;
    }
}