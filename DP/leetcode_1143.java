// https://leetcode.com/problems/longest-common-subsequence/description/
// Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        Integer[][] dp = new Integer[s1][s2]; // dp[s1][s2] will store ki in indexes tk what is the maximum  common subseq value we can get
        return findLongest(s1-1, s2-1, text1, text2, dp);

    }

    public int findLongest(int index1, int index2 , String str1, String str2, Integer dp[][]){
        //base case
        if(index1 <0 || index2 <0) return 0;
        if(dp[index1][index2] != null) return dp[index1][index2];
        //matching characters
        if(str1.charAt(index1) ==str2.charAt(index2)){
           return dp[index1][index2] = 1 + findLongest(index1-1, index2-1 , str1,str2,dp);

        }
        else{
             // non matching characters
            //fix idx1  -- move idx2
            int case1 = 0 + findLongest(index1 , index2-1 , str1, str2,dp);

            //fix idx2 -- move idx1
            int case2 = 0 + findLongest(index1-1, index2, str1 , str2,dp);  

            return dp[index1][index2] =  Math.max(case1, case2);         

        }
       
    }
}