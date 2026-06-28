class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];

        for(int num : arr){
           freq[Math.min(num, n)]++;
        }

        int ans = 1;

        for(int i = 2; i < n + 1; i++){
            int curr = ans + freq[i];
            ans = Math.min(i, curr);
        }
        
        return ans;
    }
}