// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=oizxjoit
// Longest Consecutive Sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int max =0;
        for (int num : set) {
            ///find start point
            if (!set.contains(num - 1)) {   
                int current = num;
                int length = 1; 
                // try to expand sequence whitin condition
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }   
                // Step 5: update max
                max = Math.max(max, length);
            }
        }
        return max;
    }
}