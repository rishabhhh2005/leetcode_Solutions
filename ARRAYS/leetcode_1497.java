// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
// Check If Array Pairs Are Divisible by k

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            int rem = ((num % k ) + k ) % k;
            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        for(int rem : map.keySet()){
            int freq = map.get(rem);
            if(rem == 0){
                if(freq%2!=0) return false;

            } 

            else{
                int comp = k-rem;
                if(map.getOrDefault(comp,0) != freq) return false;
            }
        }
        return true;
    }
}