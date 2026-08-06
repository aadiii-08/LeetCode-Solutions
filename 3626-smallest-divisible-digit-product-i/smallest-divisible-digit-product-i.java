class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(true){
            if(product(i) % t == 0) return i;
            i++;
        }
    }

    int product(int digit){
        int ans = 1;

        while(digit > 0){
            int rem = digit % 10;
            ans *= rem;
            digit /= 10;
        }
        return ans;
    }
}