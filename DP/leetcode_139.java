// https://leetcode.com/problems/word-break/
// Word Break
class Solution {
    Boolean[] memo; // Can substring from index can form  valid words ?
    public boolean wordBreak(String s, List<String> dict) {
        int len = s.length();
        memo = new Boolean[len];
        return recursion(0,s,dict);
        
    }
    public boolean recursion(int index , String s, List<String> dict){
        if(index == s.length()) return true;
        if(memo[index] != null) return memo[index];

        for(String d : dict){ // isme bs ye krna h ki try every possibility when we get a starting match
            if(s.startsWith(d,index)){
                if(recursion(index+d.length(),s,dict))  return memo[index]= true;
            }
        }
        return memo[index] =false;

    }
}
