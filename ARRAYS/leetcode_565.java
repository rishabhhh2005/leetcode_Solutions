// LeetCode 565. Array Nesting  
// https://leetcode.com/problems/array-nesting/

class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  
                int count = 0;
                int elem = i;
                while (!visited[elem]) {
                    visited[elem] = true;
                    elem = nums[elem];
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}
