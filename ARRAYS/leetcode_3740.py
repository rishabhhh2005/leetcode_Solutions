# https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/description
# Minimum Distance Between Three Equal Elements I
class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        mini = float('inf')

        n = len(nums)
        for i in range(n):

            for j in range(i+1,n):
                
                for k in range (j+1 ,n):

                    if(nums[i] == nums[k] == nums[j]  ):
                        abs_val = abs(i-j) + abs(j-k) + abs(k-i)
                        if( abs_val >= 0):
                            mini = min( mini , abs_val)
        if mini == float('inf'):
             return -1
        return mini


        