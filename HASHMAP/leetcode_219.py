# https://leetcode.com/problems/contains-duplicate-ii/
# Contains Duplicate II
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        n= len(nums)

        map ={}

        for i in range(n):
            num = nums[i]
            if num in map:
                j = map[num]

                if abs(i-j) <=k:
                    return True
            map[num] = i
        

        return False
        