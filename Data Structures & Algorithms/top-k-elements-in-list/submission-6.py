class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        numbers_count = {}
        for x in nums:
            numbers_count[x] = numbers_count.get(x, 0) + 1
        buckets = [[] for _ in range(len(nums) + 1)]
        
        for num, freq in numbers_count.items():
            buckets[freq].append(num)
      
        result = []

        for freq in range(len(buckets) - 1, 0, -1):
            for num in buckets[freq]:
                result.append(num)
            if len(result) == k:
                return result
        