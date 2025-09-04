 //                           LEETCODE 162: Find Peak Element
//                           https://leetcode.com/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        //base cases
        if( n <=1) return 0;
        if( n == 2){
            if(nums[0] > nums[1]) return 0;
            else return 1;
        }

        //the optimal solution i can think for is BS because the question wants O(logn).. so BS helps here only

        int  low =0;
        int high =n-1 ;

        while(low < high){

            

            int mid = low + (high - low) / 2;

            // If mid is less than the next element, peak lies on right
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Peak is at mid or to the left
                high = mid;
            }

        }
        //finally low will be the peak at the end
        return low;
        
    }


}
