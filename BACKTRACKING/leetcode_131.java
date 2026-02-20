// https://leetcode.com/problems/palindrome-partitioning/description/
// Palindrome Partitioning
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return res;
        if(s.length() == 1){
            List<String> ans = new ArrayList<>();
            ans.add(s);
            res.add(ans);
            return res;
        }
        //actual logic // easy peesy
        partition(0,new ArrayList<>(),s);
        return res;
        
    }

    public void partition(int start ,List<String> curr, String s){
        if(  start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end =start ;end < s.length();end++){
            String substr = s.substring(start , end+1);
            if(isPalindrome(substr)){ //if the substring we have is palindrome we recurse from next index
                curr.add(substr);
                partition(end+1 , curr, s);
                curr.remove(curr.size()-1);
            }

        }

    }
    public boolean isPalindrome(String s){
        int p1 =0;
        int p2 = s.length()-1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++; p2--;
        }
        return true;
    }
}
