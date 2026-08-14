class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int left = 0, right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.get(ch) > 2){
                char prev = s.charAt(left);
                map.put(prev, map.getOrDefault(prev, 0) - 1);
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }
}