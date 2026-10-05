class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j <= s.length(); j++){
                if(isPalindrom(s.substring(i, j))) ans++;
            }
        }

        return ans;
    }


    boolean isPalindrom(String s){
        if(s.length() == 0) return false;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}