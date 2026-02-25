// https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Frequency of the Most Frequent Element
class Solution {
    long max=1;
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int left =0;
        int right =1;
        Arrays.sort(nums);
        long sum = nums[0];
        while(right < n){
            sum+=nums[right];
            long window = right-left+1;
            long cost = (nums[right] * (window) )   - sum;
            if(cost <=k) max= Math.max(max,window);
            while(cost > k) {
            
                sum -= nums[left];
                left++;
                window = right-left+1;
                cost = nums[right]*window  -sum;
            }
        
            right++;
        }
        return (int)max;
        
    }
}