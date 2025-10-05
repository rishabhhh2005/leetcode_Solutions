// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {
    private static final Map<Character, String> phoneMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
          if (digits == null || digits.length() == 0) return result;
    

        helper(digits , 0 , new StringBuilder(),result);

        return result;
    }

    public void helper(String digits , int index, StringBuilder current, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return;

        }

        String letters = phoneMap.get(digits.charAt(index));
        for(char c : letters.toCharArray()){
            current.append(c);
            helper(digits , index+1, current , result);
            current.deleteCharAt(current.length()-1);

        }
    
    }
}