class Solution:
    def maxProduct(self, n: int) -> int:
        a=0
        b=0
        while n>0:
            re=n%10
            n=n//10
            if a<=re:
                b=a
                a=re
            elif b<=re:
                b=re
        return b*a
