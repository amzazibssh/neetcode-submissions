class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        copies = {}
        for x in nums: 
            if x in copies:
                return True
            copies[x] = 1
        return False