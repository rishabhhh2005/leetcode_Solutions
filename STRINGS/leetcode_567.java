//                                          LeetCode 567: Permutation in String
//                                          https://leetcode.com/problems/permutation-in-string/
 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[]str1 = new int[26];
        int [] str2 = new int[26];

        if (s1.length() > s2.length()) return false;


        int windowsize = s1.length();
        for(char c : s1.toCharArray()){
            str1[c-'a']++;

        }

        for(int i=0;i<s2.length();i++){
            str2[s2.charAt(i)-'a']++;


            if( i>=windowsize){
                str2[s2.charAt(i-windowsize)-'a']--;

            }
            if(Arrays.equals(str1,str2)) return true;
        }

        return false;
        
    }
}