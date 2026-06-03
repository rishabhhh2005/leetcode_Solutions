// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
// Maximum Sum of Distinct Subarrays With Length K
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = Integer.MIN_VALUE;
        int maxstart=0; 
        if(k==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;  int left =0;  int right=0;

        long currsum =0;
        while(right<n){
            int elem = nums[right];
            map.put(elem, map.getOrDefault(elem,0)+1);
            currsum += elem;

            while(map.get(elem) >1 || right-left+1 >k){
                int leftelem = nums[left];
                map.put(leftelem, map.get(leftelem)-1);
                currsum -= leftelem;
                if(map.get(leftelem) == 0) map.remove(leftelem);
                left++;
            }
            if(right- left +1 == k) max = Math.max(max, currsum);
            right++;   

        }
        return max == Integer.MIN_VALUE?0:max;
        
        
    }
}