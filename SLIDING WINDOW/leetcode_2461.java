// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
// Maximum Sum of Distinct Subarrays With Length K
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = Integer.MIN_VALUE;
        if(k==0) return 0;
        Set<Integer> set = new HashSet<>();
        int n = nums.length;  int left =0;  int right=0;
        long currsum =0;
        while(right<n){
            int elem = nums[right];
            
            while( set.contains(elem) || right-left+1 >k){
                int leftelem = nums[left];
                set.remove(leftelem);
                currsum -= leftelem;
                left++;
            }
            set.add(elem);
            currsum += elem;
            if(right- left +1 == k) max = Math.max(max, currsum);
            right++;   

        }
        return max == Integer.MIN_VALUE?0:max;
        
        
    }
}