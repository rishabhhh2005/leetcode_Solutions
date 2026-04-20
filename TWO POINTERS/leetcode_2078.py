# https://leetcode.com/problems/two-furthest-houses-with-different-colors/
# Two Furthest Houses With Different Colors
class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        n = len(colors)
        # try from both corner
        maxi =1
        corner1 =colors[0]
        corner2 = colors[n-1]
        for i in range(n):
            if colors[i] != corner1:
                maxi = max(maxi , i)
            if colors[n-i-1] != corner2:
                maxi =max(maxi ,i)
        return maxi
        