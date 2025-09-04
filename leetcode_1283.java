//                           LEETCODE 1283: Find the Smallest Divisor Given a Threshold
//                           https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
     
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int low =1;
        int high =max;
        int ans =max;

        while(low<=high){

            int mid = low +(high -low )/2;
            int curr_threshold = thresholdcalculator(nums , mid);

            if( curr_threshold<=threshold){
                ans =mid;
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }

        

        return ans;

        
    }
    public int thresholdcalculator(int[] arr , int div){
        int sum=0;
       
        
        for(int i=0;i<arr.length;i++){
            sum += (arr[i] + div - 1) / div;  // integer ceil logic

        }

        return sum;
        

    }
}