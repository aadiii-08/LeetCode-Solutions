class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if(ch == ')'){
                count--;
            }
            
            if (count < 0) {
                ans++;
                count++;
            }
        }

        ans += count;

        return ans;
    }
}