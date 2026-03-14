// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
// The k-th Lexicographical String of All Happy Strings of Length n
class Solution {
    List<String> res = new ArrayList<>();
    int k ;
    int n;
    public String getHappyString(int n, int k) {
        // the approach i can think of is -> generate all possible  happy strings
        // then return the kth shit
        this.k=k;  this.n=n;
        generateHappyStrings(new StringBuilder());

        if(res.size()== 0 || k> res.size()) return "";
        return res.get(res.size()-1);    
    }
    public void generateHappyStrings(StringBuilder curr ){
      
        if(res.size() == k) return;
        if(curr.length() == n){
           res.add(curr.toString());
            return;
        }
        for(int i=0;i<=2;i++){
            // i= 0  ->   convert it to a which is 97
            char c = (char)(i+97);

            if(( !curr.isEmpty() && curr.charAt(curr.length()-1) != c ) ||  curr.isEmpty()){
                curr.append(c); // add if valid
                generateHappyStrings(curr); //recurse
                curr.deleteCharAt(curr.length()-1); // backtrack
            }

        }
    }
}