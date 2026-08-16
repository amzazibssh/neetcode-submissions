class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        i, j = 0, 1
        while j <= len(nums) - 1:
            if nums[i] == nums[j]:
                return True
            j += 1
            i += 1
        return False