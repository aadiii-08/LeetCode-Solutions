class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;
        int count = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                count++;
            }

            if (count == k) {

                // Remove leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }

                String curr = s.substring(left, right + 1);

                // Check shortest, then lexicographically smallest
                if (ans.equals("")
                        || curr.length() < ans.length()
                        || (curr.length() == ans.length()
                            && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }

                // Move left past the first '1'
                left++;
                count--;
            }
        }

        return ans;
    }
}