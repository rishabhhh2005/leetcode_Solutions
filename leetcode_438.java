//                                          LeetCode 438: Find All Anagrams in a String 
//                                          https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int windowsize = p.length();
        List<Integer> res = new ArrayList<>();

        int[]scount = new int[26];
        int[] pcount = new int[26];
        
        for(char c : p.toCharArray()){

            pcount[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            scount[s.charAt(i) -'a']++;

            if(i>=windowsize){
                scount[s.charAt(i-windowsize) -'a']--;

            }

            if(Arrays.equals(scount , pcount)){
                res.add(i-windowsize+1);
            }
        }

        return res;

    }
}