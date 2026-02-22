// https://leetcode.com/problems/koko-eating-bananas/description/
// 875. Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] bananas, int h) {
        if(bananas.length == 0 || h == 0) return 0;
        int max = bananas[0];
        for(int b : bananas) max= Math.max(max,b);
        int left =1;
        int right = max;
        int ans =max;

        while(left <= right){
            int mid = left + (right-left)/2;
            int totalTime=0;
            for(int b : bananas){
                totalTime += Math.ceil((double)b/mid); //mid == rate here
            }
            
            if(totalTime <=h){
                //search in left
                ans = mid;
                right = mid-1;
            }
            else{
                //search in right
                left = mid+1;
            }
        }
        return ans;
        
    }
    
}
