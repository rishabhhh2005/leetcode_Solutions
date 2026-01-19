// https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1890084457/
// Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] nums, int k) {
        //Approach i will be using  : sliding window + 2 pointer with atmost k zeroes
        int left =0;
        int right =0;
        int n = nums.length;
        int zerocount=0;
        int maxlen =0;
        int windowlen =0;
        while(right<n){
            if(nums[right] == 1) { /*good*/ }
            else {
                if(nums[right] == 0 ){
                    zerocount++;
                    if(zerocount<=k){ /*good */ }
                    else{ //zerocount > k
                        //we need to shrink the window by left pointer
                        while(nums[left] != 0 ) left++;
                        left = left+1; // move left ahead exclusing the zero
                        zerocount--; // excluse the leftmost zero     
                    }
                }
                
            }
            right++;
           
            windowlen = right - left;
            maxlen = Math.max(maxlen, windowlen);

        }
        return maxlen;
        
    }
}