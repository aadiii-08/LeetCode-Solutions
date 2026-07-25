class Solution:
    def maxProduct(self, n: int) -> int:
        s=str(n)
        l=[]
        for i in range(len(s)):
            l.append(int(s[i]))
        l.sort(reverse=1)
        return l[0]*l[1]
