// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Letter Combinations of a Phone Number
class Solution {
    List<String> res = new ArrayList<>();
    Map<Integer , String> map = new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        map.put(2 , "abc");
        map.put(3, "def");
        map.put(4 , "ghi");
        map.put(5 , "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backTrack(0,"",digits);
        return res;
        
    }
    public void backTrack(int index, String currString, String digits){
        if(index == digits.length()){
            res.add(currString);
            return;
        }

        String letters = map.get(digits.charAt(index) - '0');

        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            backTrack(index + 1, currString + c, digits);
        }
    }

}
