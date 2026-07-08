class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            freq[curr]++;
        }

        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            if(freq[curr] == 1) return i;
        }

        return -1;
    }
}