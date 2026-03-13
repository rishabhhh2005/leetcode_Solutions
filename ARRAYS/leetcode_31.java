// https://leetcode.com/problems/next-permutation/
// Next Permutation
class Solution {
    // in order to solve this questions
    // we need to look for logngest prefix max
    // so we will do like [ *,* *,* *,* *,* *,* *,* ] <--------------------
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int stop =-1;
        // we need to find the element drop  from LEFT  TO RIGHT

        for(int i= n-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                stop = i-1;
                break;
            }
        }
        if( stop < 0 || stop ==  n-1) { // edge case -> we cannot find pivot elem
            //reverse
            Arrays.sort(nums); // get the first permutation and we will get it by sorting
            return;
        }
        //now find the index just greater than curr index
        int possibleIndex = stop+1;
        int min = nums[possibleIndex] - nums[stop];
        for(int start = stop+1; start< n;start++){
            int diff = nums[start] - nums[stop];
            if(diff > 0){
                if(diff < min){
                    possibleIndex = start;
                    min = diff;
                }
            }

        }
        //swap
        int temp = nums[stop];
        nums[stop] = nums[possibleIndex];
        nums[possibleIndex] = temp;
        // now just sort after stop
        Arrays.sort(nums, stop +1, n);
    }
}