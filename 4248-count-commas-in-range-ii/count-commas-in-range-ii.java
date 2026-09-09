class Solution {
    public long countCommas(long n) {
        // first method

        // long ans = 0;
        // long lower = 1000;
        // long comma = 1;

        // while(lower <= n){
        //     long upper = lower * 1000 - 1;
        //     if(upper > n) upper = n;

        //     long countNum = upper - lower + 1;
        //     ans += (countNum * comma);

        //     lower *= 1000;
        //     comma++;
        // }

        // second method

        long ans = 0;
        long start = 1000;
        while(start <= n){
            ans += (n - start + 1);
            start *= 1000;
        }

        return ans;
    }
}