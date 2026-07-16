class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);
        long sum = 0;

        for(int i = 0; i < n/2; i++){
            sum += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return sum;
    }

    int gcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}