class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            v = nums[i]
            diff = target - v
            if diff in seen:
                return [seen[diff], i]
            seen[v] = i