// https://leetcode.com/problems/contiguous-array/
// Contiguous Array
class Solution { // prefix sum + HashMap
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();  //sum , firstIndex
        map.put(0 , -1);
        int prefixsum = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) prefixsum -=1;
            if(nums[i] == 1) prefixsum +=1;

            int currStart = i;
            if(map.containsKey(prefixsum)){
                max = Math.max(max ,  currStart - map.get(prefixsum) );
            }
            else map.put(prefixsum , currStart); // only add first occurence

        }
        return max;
    }
}