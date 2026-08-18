class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        a=nums[0]
        b=nums[-1]
        c=[-1]
        if len(nums)==k:
            return max(nums)
        if k==1:
            for i in nums:
                if nums.count(i)==1:
                    c.append(i)
            return max(c)
        if nums.count(a)==1:
            c.append(a)
        if nums.count(b)==1:
            c.append(b)
        return max(c)
