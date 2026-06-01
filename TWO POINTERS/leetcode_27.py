# https://leetcode.com/problems/remove-element/
# Remove Element
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        n= len(nums)
        if n ==0: return 0
        ptr1=0
        ptr2 = n-1
        
        while ptr1 < ptr2:
        
            if nums[ptr2] != val:
                if nums[ptr1] == val:
                    nums[ptr1] , nums[ptr2] = nums[ptr2], nums[ptr1]
                    ptr1+=1
                    ptr2-=1
                else:
                    ptr1+=1
            else:
                ptr2-=1
        

        ans =0
        for x in nums:
            if x == val: break
            ans+=1
        return ans




        