// https://leetcode.com/problems/count-sequences-with-product-k/description/
// 3850. Count Sequences With Product K
class Solution {
    // WE WILL USE 3D DP FOR 3 STATES
    // WE CANNOT USE ARRAY DP BECAUSE NUM AND DENOM CAN OVERFLOW IN MULTIPLICATION
    // THATS WHY WE STORE INDEX , STRING MAP
    Map<Integer ,Map<String, Integer>>memo = new HashMap<>();
    public int countSequences(int[] nums, long k) {
        if(nums.length == 0) return 0;

        return recursion(0,1,1,nums, k,memo);
        
        
    }
    public int recursion(int index, long numerator, long denominator, int[] nums , long k,
    Map<Integer , Map<String, Integer>> memo){

        if(index == nums.length){
            if(numerator ==  k*denominator) return 1; // since (curr = num/denom)   === k
                                                      //else it will become num/denom == k and
                                                      // eventually num == denom*k;
            return 0;
        }
        String key = numerator+ "/" + denominator;
        if (memo.containsKey(index) && memo.get(index).containsKey(key)) {
            return memo.get(index).get(key);
        }

        int case1 =recursion(index+1 , numerator * nums[index] ,denominator , nums , k,memo);
        int case2 = recursion(index+1 , numerator, denominator * nums[index] , nums , k,memo);
        int case3 = recursion(index+1 , numerator , denominator  , nums  ,k,memo);

        int ans = case1 + case2 + case3;

        memo.putIfAbsent(index, new HashMap<>());
        memo.get(index).put(key, ans);
        return ans;

       

    }
}