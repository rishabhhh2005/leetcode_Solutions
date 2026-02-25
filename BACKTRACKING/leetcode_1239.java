// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
// Maximum Length of a Concatenated String with Unique Characters
class Solution {

    int maxLen = Integer.MIN_VALUE;

    public int maxLength(List<String> arr) {
     
        helper(0, 0, new StringBuilder(), arr);
        return maxLen;
    }

    public void helper(int index, int currLen, StringBuilder sb, List<String> arr) {
        // every state can be valid ans
        maxLen = Math.max(maxLen, currLen);
        if(index == arr.size()) return;

        String currStr = sb.toString();
        int oldLen = sb.length(); //old len store for backtracking
        // combination logic: 
        for(int i = index; i < arr.size(); i++){
            String newStr = arr.get(i);
            if(valid(newStr, currStr)){
                sb.append(newStr);    // choose 
                helper(i + 1, currLen + newStr.length(), sb, arr); // explore
                sb.setLength(oldLen);  // un-choose 
            }
        }
    }

    public boolean valid(String a, String b) {
        java.util.Set<Character> s = new java.util.HashSet<>();
        for(char c : (a + b).toCharArray())  if(!s.add(c)) return false;
        return true;
    }
}