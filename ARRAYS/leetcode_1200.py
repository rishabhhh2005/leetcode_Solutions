# https://leetcode.com/problems/minimum-absolute-difference/description/?envType=daily-question&envId=2026-06-06
# Minimum Absolute Difference
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        n = len(arr)

        min_diff =float("inf")

        for i in range(n-1):
            min_diff = min(min_diff , arr[i+1]-arr[i])
           
        
        list =[]

        for i in range(n-1):
            if arr[i+1]- arr[i] == min_diff: list.append((arr[i], arr[i+1]))
        return list
        