class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            char ch = seq.charAt(i);

            if(ch == '(' && count % 2 == 0){
                ans[i] = 0;
                count++;
            }else if(ch == '(' && count % 2 == 1){
                ans[i] = 1;
                count++;
            }else if(ch == ')' && count % 2 == 0){
                ans[i] = 1;
                count--;
            }else{
                ans[i] = 0;
                count--;
            }
        }

        return ans;
    }
}