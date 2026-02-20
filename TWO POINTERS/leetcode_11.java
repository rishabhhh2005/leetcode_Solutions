// https://leetcode.com/problems/container-with-most-water/description/
// Container With Most Water
class Solution {
    // Start with two pointers at both ends, compute area, and always move the pointer at
    // the smaller height inward because only that can potentially increase the area while 
    //width decreases.
    int maxarea = 0;
    public int maxArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return  0;

        int p1 = 0;
        int p2 = n-1;

        while( p1 < p2){
            if(p1 >= n || p2 >=n || p1 <0 || p2 < 0) break;
            int min = Math.min(heights[p1] , heights[p2]);
            int currarea= (p2-p1)*(min);
            maxarea = Math.max(maxarea, currarea);
            if(heights[p2] == min) p2--;
            else p1++;
        }
        return maxarea;
        
    }
}
