// https://leetcode.com/problems/subarrays-with-k-different-integers/
// Subarrays with K Different Integers
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Sliding Window + Two Pointer approach
        
        // Idea:
        // Exactly K distinct subarrays =
        // (Subarrays with at most K distinct)
        // - (Subarrays with at most K-1 distinct)
        
        if (k == 0 || nums.length == 0) return 0;

        return returnuptoK(nums, k) - returnuptoK(nums, k - 1);
    }

    public int returnuptoK(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;  // total valid subarrays count
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // right pointer se window expand karte jao
        while (right < n) {

            // nums[right] ko window me add karo
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Agar distinct elements k se zyada ho gaye
            // toh left pointer ko move karo (window shrink)
            while (map.size() > k) {
                int currelem = nums[left];

                // left element ki frequency kam karo
                map.put(currelem, map.get(currelem) - 1);

                // Agar frequency 0 ho gayi toh map se remove
                if (map.get(currelem) == 0) {
                    map.remove(currelem);
                }

                left++; // window ko left se shrink karo
            }

            // Ab window valid hai (<= k distinct)
            // right pe end hone wale saare subarrays count karo
            // Number of subarrays = (right - left + 1)
            count += (right - left + 1);

            right++; // window ko right se expand karo
        }

        return count;
    }
}
