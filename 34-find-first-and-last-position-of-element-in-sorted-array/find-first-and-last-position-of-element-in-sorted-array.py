class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        first = -1
        last = -1
        low = 0
        high = len(nums)-1
        while low<=high:
            guess = (low+high)//2
            if nums[guess] == target:
                first = guess
                high = guess-1
            elif nums[guess]<target:
                low = guess+1
            else:
                high = guess-1
        low = 0
        high = len(nums)-1
        while low<=high:
            guess = (low+high)//2
            if nums[guess] == target:
                last = guess
                low = guess+1
            elif nums[guess]<target:
                low = guess+1
            else:
                high = guess-1
        return [first,last]