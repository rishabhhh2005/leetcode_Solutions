// https://leetcode.com/problems/maximum-average-subarray-i/description/
// Maximum Average Subarray I
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return (double)nums[0];
        int left =0 ;
        int right =0;
        int avgsum=0;  double max =Integer.MIN_VALUE;
        while(right < n){
            double newavg;
            avgsum += nums[right];
            

            if(right-left+1 > k){
                avgsum -= nums[left];
                left++; 
            }
            
            
            newavg = avgsum/(double)(right-left+1);
            if(right-left+1 == k) max = Math.max(max, newavg);
            right++;

        }
        return max;
        
    }
}