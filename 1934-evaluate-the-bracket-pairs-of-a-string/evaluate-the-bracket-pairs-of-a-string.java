class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String, String> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for(List<String> know : knowledge){
            map.put(know.get(0), know.get(1));
        }

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);

            if(curr == '('){
                StringBuilder sb = new StringBuilder();
                int idx = i + 1;
                while(s.charAt(idx) != ')'){
                    sb.append(s.charAt(idx));
                    idx++;
                }
                if(map.containsKey(sb.toString())){
                    ans.append(map.get(sb.toString()));
                }else{
                    ans.append('?');
                }
                i = idx;
            }else{
                ans.append(curr);
            }
        }

        return ans.toString();
    }
}