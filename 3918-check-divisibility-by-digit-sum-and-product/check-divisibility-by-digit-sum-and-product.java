class Solution {
    public boolean checkDivisibility(int n) {
        int val = sum(n) + product(n);
        return n % val == 0;
    }

    int sum(int n){
        int ans = 0;
        
        while(n > 0){
            ans += n % 10;
            n /= 10;
        }

        return ans;
    }

    int product(int n){
        int ans = 1;

        while(n > 0){
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }
}