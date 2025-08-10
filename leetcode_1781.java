//                                      LeetCode Problem 1781: Sum of Beauty of All Substrings
//                                      https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

class Solution {
    public int beautySum(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            int[]freq = new int[26];
            for(int j =i;j<s.length();j++){

                freq[s.charAt(j) -'a']++;
                total+=beautyof(freq);
            }
        }

        return total;
        
    }

    public int beautyof(int[]freq){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int f : freq){
            if(f>0){
                max = Math.max(max,f);
                min = Math.min(min,f);

            }
        }

        return max-min;
    }
}