class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 2 * n - 1; i >= 0; i--){
            int idx = i % n;
            while(!s.isEmpty() && s.peek() <= nums[idx]){
                s.pop();
            }
            
            if(i < n){
                res[idx] = s.isEmpty() ? -1 : s.peek();
            }

            s.push(nums[idx]);
        }

        return res;
    }
}