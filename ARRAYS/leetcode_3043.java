// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/?envType=daily-question&envId=2026-05-21
// Find the Length of the Longest Common Prefix
// Better Aproach : Use Trie
class Solution {
    int max;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        max =0;
        Set<String> set = new HashSet<>();
        //put all LCP of array 1 into the Set

        for(int x : arr1){
            String s = String.valueOf(x);
            StringBuilder  sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(c);
                set.add(sb.toString());
            }
        }


        for( int x : arr2){
              String s = String.valueOf(x);
            StringBuilder  sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(c);
                if(set.contains(sb.toString())){
                    max = Math.max(max , sb.length());
                }
            }

        }
        return max;
        
    }
}