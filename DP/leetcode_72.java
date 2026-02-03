// https://leetcode.com/problems/edit-distance/
// Edit Distance
class Solution {
   Integer[][] dp;
    public int minDistance(String word1, String word2) {
        if(word2.length()==0) return word1.length();
        if(word1.length() == 0) return word2.length();
        // we will solve this Problem By DP
        // Trying out all possible ways
        
        // dp[index1][index2] will represent upto index1 on s1 and upto index2 on s2 how many operations are needed
        dp = new Integer[word1.length()][word2.length()];
        return minOps(0,0,word1 , word2, dp);
        
    }
    public int  minOps(int index1, int index2, String word1 , String word2, Integer[][] dp){
        if(index1 == word1.length() ) return word2.length()- index2;
         if(index2 == word2.length() ) return word1.length()- index1;
        if(dp[index1][index2] != null) return dp[index1][index2];
        if(word1.charAt(index1) ==  word2.charAt(index2)){
            return dp[index1][index2] =minOps(index1+1, index2+1, word1, word2,dp);
        }
        else{
            // We have 3 operations possible:

            // 1️⃣ Insert
            // word1 me word2[index2] ka character insert kar rahe hain
            // Isliye index2 aage badhega (character match ho gaya)
            // index1 same rahega kyunki word1 ka current char abhi process nahi hua
            int insert = 1 + minOps(index1, index2 + 1, word1, word2, dp);

            // 2️⃣ Delete
            // word1[index1] ka character delete kar rahe hain
            // Isliye index1 aage badhega
            // index2 same rahega kyunki word2 ka current char abhi match karna hai
            int delete = 1 + minOps(index1 + 1, index2, word1, word2, dp);

            // 3️⃣ Update (Replace)
            // word1[index1] ko word2[index2] se replace kar rahe hain
            // Dono characters process ho gaye → dono indices aage badhenge
            int update = 1 + minOps(index1 + 1, index2 + 1, word1, word2, dp);

            // Minimum operations choose kar rahe hain
           return dp[index1][index2] = Math.min(update , Math.min(insert, delete));
        }
     

    }
}