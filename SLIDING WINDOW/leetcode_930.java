// https://leetcode.com/problems/binary-subarrays-with-sum/submissions/1891774041/
// Binary Subarrays With Sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        // no of subarrays with sum goal
        int a = noOfsubarrays(nums,goal);
        //no of subarrays with sum goal-1
        int b = noOfsubarrays(nums,goal-1);

        return a-b;
    }
    public int noOfsubarrays(int[]nums, int goal){
        if (goal < 0) return 0;
        int n = nums.length;
        int left =0;
        int right =0;
        int currsum=0;
        int count =0;
        while(right < n){
            currsum += nums[right];
            
            while(currsum >goal){
                currsum -= nums[left];
                left++;
            }
            count += (right-left +1); 
            // right index pe end hone wale saare valid subarrays ka count
            // kyunki left se right tak kisi bhi start se sum <= goal rahega
            right++;
        }
        return count;
    }
}