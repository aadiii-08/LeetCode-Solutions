class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        comb(ans, new StringBuilder(), digits, map, 0); 
        return ans;
    }

    void comb(List<String> ans, StringBuilder curr, String digits, String[] map,  int idx){
        if(idx == digits.length()){
            ans.add(curr.toString());
            return;
        }

        String letter = map[digits.charAt(idx) - '0'];  
        for(int i = 0; i < letter.length(); i++){
            curr.append(letter.charAt(i));
            comb(ans, curr, digits, map, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}