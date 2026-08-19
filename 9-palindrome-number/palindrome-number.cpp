class Solution {
public:
    bool isPalindrome(int x) {
        int t = x;
        long long rev = 0;
        if(x<0)
        {
            return false;
        }
        while(t>0)
        {
            int d = t % 10;
            rev = rev * 10 + d;
            t /= 10;
        }

        return (x == rev);
    }
};