//                                           LeetCode 1011 - Capacity To Ship Packages Within D Days
//                                 Problem Link: https://leetcode.com/problems/capacity-to-ship-packages-within

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n= weights.length;

        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int num : weights){
            max = Math.max(num, max);
            sum+=num;
        }

        int low =  max;
        int high = sum;

        while(low<high){
            int mid = low +(high-low)/2;

            if(canShipUnderdeadline(weights, mid, days)){
                high=mid;

            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }

    public boolean canShipUnderdeadline(int[] arr , int capacity , int days){
        
        int requireddays =1;
        int currload =0;

        for(int weight : arr){
            if(currload + weight > capacity){
                requireddays++;
                currload=0;
            }
            currload+=weight;
        }

        return requireddays<=days;
       
        

    }
}