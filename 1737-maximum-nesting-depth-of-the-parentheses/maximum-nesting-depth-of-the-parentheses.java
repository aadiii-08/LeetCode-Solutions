class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        int depth = 0;

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr == '('){
                depth++;
                ans = Math.max(ans, depth);
            }
            if(curr == ')') depth--;
        }

        return ans;
    }
}