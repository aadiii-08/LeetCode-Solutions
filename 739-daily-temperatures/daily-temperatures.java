    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Stack<Integer> s = new Stack<>();
            int[] ans = new int[n];

            for(int i = n - 1; i >= 0; i--){
                while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                    s.pop();
                }

                ans[i] = s.isEmpty() ? 0 : s.peek() - i;
                s.push(i);
            }

            return ans;
        }
    }