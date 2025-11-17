// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// 1437. Check If All 1's Are at Least Length K Places Away
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if(nums.length == 0) return true;
        int p1=0;
        while( p1 < nums.length && nums[p1] != 1 ) p1++;
        int p2 = p1+1;

        int counter=1;
        while(p2 < nums.length){
            if( nums[p2] == 1 && counter<=k) return false;
            if(nums[p2] == 1){
                p1 = p2;
                counter=0;
                
            }
            counter++;
            p2++;
             
            
        }
        return true;

        
    }
}