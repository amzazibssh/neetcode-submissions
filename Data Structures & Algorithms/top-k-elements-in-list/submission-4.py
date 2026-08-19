class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        numbers_count = {}
        for x in nums:
            if x in numbers_count:
                numbers_count[x] += 1
            else:
                numbers_count[x] = 1
        sorted_d = dict(
            sorted(
                numbers_count.items(), 
                key=lambda item: item[1]
            )
        )
        return list(sorted_d.keys())[len(sorted_d) - k:]
        