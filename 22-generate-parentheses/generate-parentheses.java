class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(2*n, sb);
        return ans;
    }

    void solve(int n, StringBuilder sb){
        if(sb.length() == n){
            if(isValid(sb)){
                ans.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        solve(n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        solve(n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    boolean isValid(StringBuilder sb){
        int count = 0;
        for(int i = 0; i < sb.length(); i++){
            if(count < 0) return false;
            if(sb.charAt(i) == '(') count++;
            if(sb.charAt(i) == ')') count--;
        }

        return count == 0;
    }
}