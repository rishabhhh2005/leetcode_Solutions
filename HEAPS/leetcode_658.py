# https://leetcode.com/problems/find-k-closest-elements/
# Find K Closest Elements
import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pq= []

        for a in arr:
            dist = abs(a-x)
            heapq.heappush(pq , [-dist,-a])

            if len(pq) >k:
                heapq.heappop(pq)
        

        res =[]

        for distance , elem in pq:
            res.append(-elem)
        return sorted(res)
        