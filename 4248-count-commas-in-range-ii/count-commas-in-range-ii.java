class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long lower = 1000;
        long comma = 1;

        while(lower <= n){
            long upper = lower * 1000 - 1;
            if(upper > n) upper = n;

            long countNum = upper - lower + 1;
            ans += (countNum * comma);

            lower *= 1000;
            comma++;
        }
        return ans;
    }
}