# https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/
# Shortest Distance to Target String in a Circular Array
class Solution:
    def closestTarget(self, words: List[str], target: str, start: int) -> int:
        # store all possible indexes of target first
        indexes =[]
        n = len(words)
        for  i, x in enumerate(words):
            if x == target:
                indexes.append(i)
        
        if len(indexes) == 0: return -1

        mini = float('inf')
        for index  in indexes:

            d1 = abs(index-start) # forward distance to the target
            d2 = n - d1 # reverse distance to the target
            mini = min(d1 , d2 , mini)
        
        return mini


        