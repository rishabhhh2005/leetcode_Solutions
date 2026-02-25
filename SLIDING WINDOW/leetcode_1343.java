// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
// Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int left =0, right=0 , currsum =0, count =0 ;
        // easy peesy Sliding Window
        while(right < len){
            int curr = arr[right];
             int window = right-left+1;
             currsum = currsum + curr;
            if(window > k){
                currsum = currsum - arr[left];
                left++;
                window--;
            }
            
            if(window == k){
                int avg = currsum/window;
                if(avg >= threshold) count++;
            }
            
            right++;

        }
        return count;
        
    }
}