// // https://leetcode.com/problems/single-number/description/
// // 136. Single Number


// class Solution {
//     public int singleNumber(int[] nums) {
//     Set<Integer> myset = new HashSet<>();
//     for(int  i=0;i<nums.length;i++){
//         if(myset.contains(nums[i])){
//             myset.remove(nums[i]);
//         }
//         else{
//             myset.add(nums[i]);
//         }
//     }

//     for( int i : myset){
//         return i;

//     }
//     return 0;
        
//     }
// }

// new approach using bit manipulation
class Solution {
    public int singleNumber(int[] nums) {
        int xor =0;
        for(int x : nums) xor ^=x;
        return xor;
    }
}

