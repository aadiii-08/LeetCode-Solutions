class Solution {
    int n;
    HashSet<String> ans;
    int maxLen;
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        maxLen = 0;
        n = s.length();
        StringBuilder curr = new StringBuilder();
        
        solve(0, curr, 0, s);
        return new ArrayList<>(ans);
    }

    void solve(int i, StringBuilder curr, int count, String s){
        // if at any index it is invalid
        if(count < 0) return;

        // if idx is gone out of bound
        if(i == n){
            // if string is valid at last idx then add in ans
            if(count == 0){
                if(curr.length() > maxLen){
                    maxLen = curr.length();
                    ans = new HashSet<>();
                }
                if(curr.length() == maxLen){
                    ans.add(curr.toString());
                }
            }
            return;
        }

            // for any character
            if(s.charAt(i) != '(' && s.charAt(i) != ')') {
                curr.append(s.charAt(i));
                solve(i + 1, curr, count, s);
                curr.deleteCharAt(curr.length() - 1);
                return;
            }

            curr.append(s.charAt(i));
            solve(i + 1, curr, count + (s.charAt(i) == '(' ? 1 : -1), s);
            curr.deleteCharAt(curr.length() - 1);
            solve(i + 1, curr, count, s);
    }
}