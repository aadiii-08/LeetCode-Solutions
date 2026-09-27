class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr == '('){
                st.push(i);
            }else if(curr == ')'){
                int right = i;
                int left = st.pop();
                while(left < right){
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(' || arr[i] == ')'){
                continue;
            }else{
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}