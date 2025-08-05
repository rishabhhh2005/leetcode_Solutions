//                                          1539. Kth Missing Positive Number
//                                          https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n =arr.length;
        int missing_numbers=0;
        int prev=0;
        for(int curr=0;curr<n;curr++){

            int gap = arr[curr]-prev-1;
            if(missing_numbers +gap >=k){
                return prev + (k-missing_numbers);
            }

            missing_numbers+=gap;
            prev=arr[curr];
            
            
        }

        return arr[arr.length-1] +(k-missing_numbers);
        
    }
}