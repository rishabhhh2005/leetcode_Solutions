// https://leetcode.com/problems/sort-array-by-parity/description/
// Sort Array By Parity
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n =  nums.length;
        int evenindex=0;
        int oddindex = n-1;
        int[] res = new int[n];
        for(int x : nums){
            if(x%2 ==0){
                res[evenindex] =x;
                evenindex++;
            }
            else{
                res[oddindex] =x;
                oddindex--;
            }
        }
        return res;    
    }
}