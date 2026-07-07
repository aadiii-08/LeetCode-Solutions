class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int x = 0;
        int mul = 1;

        while(n != 0){
            int rem = n % 10;
            n /= 10;
            if(rem == 0) continue;
            x = x + rem * mul;
            mul *= 10;
            sum += rem;
        }

        return (long) x * sum;
    }
}