// https://leetcode.com/problems/single-number-iii/description/
// 260. Single Number III
class Solution {
    public int[] singleNumber(int[] nums) {
    
        Set<Integer> ones = new HashSet<>();
        Set<Integer> multis = new HashSet<>(0);

        for(int i=0;i<nums.length;i++){
            int elem = nums[i];
            if(!ones.contains(elem) && !multis.contains(elem)){
                ones.add(elem);

            }
            else if(ones.contains(elem)){
                ones.remove(elem);
                multis.add(elem);
            }
            else{
                continue;

            }
        }
        int[] res = new int[2];
        int i=0;
        for(int num : ones){
            res[i] = num;
            i++;
        }
        return res;
        
    }
}
        
    
