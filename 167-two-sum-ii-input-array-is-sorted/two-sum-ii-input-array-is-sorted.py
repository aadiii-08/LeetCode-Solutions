class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        low = 0
        high = len(numbers)-1
        while low<high:
            value = numbers[low]+numbers[high]
            if value>target:
                high -= 1
            elif value<target:
                low += 1
            else:
                return [low+1, high+1]