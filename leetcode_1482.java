//                           LEETCODE 1482: Minimum Number of Days to Make m Bouquets
//                           https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if( (long)m*k > bloomDay.length) return -1;

        //so this is a great question
        //the approach is simple ofc BS because i have tried Brute force bytraversing thru every day but ofc Leetcode with a TLE is my enemy haha
        
        int low =0;
        int high = Integer.MIN_VALUE;
        for (int num : bloomDay) {
            high = Math.max(high, num);
        }


        while(low<high){

            int mid = low +(high-low)/2;
            //simple binary search taki hm 0(logn) time complexity me aa ske
            if(canMakeBouquets(bloomDay , m , k, mid)){
                //search for lesser days
                high=mid;
            }
            else{
                //we need more days brooo
                low =mid+1;
            }
        }
        return low;
    }

    public boolean canMakeBouquets(int[] bloomDay ,int m  , int k , int days){
        //simple adjacent check
        int adjacent =0;
        int bouquet =0;
         
        for(int bloom : bloomDay){

            if(bloom <=days){
                adjacent++;

                if(adjacent == k){
                    bouquet++;
                    adjacent=0;
                }
            }

            else{
                adjacent=0;
            }
        }
        return bouquet>=m;


    }
}