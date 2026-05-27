// https://leetcode.com/problems/count-the-number-of-special-characters-ii/?envType=daily-question&envId=2026-05-27
// Count the Number of Special Characters II
class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int count=0;
        for( int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)) map.put(c , i);
        }
        for( int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                char up = Character.toUpperCase(c);
                if(map.containsKey(up)) {
                   if (map.get(up) > i){
                        count++;
                    }
                    map.remove(up);
                }
            }
        }
        return count;       
    }
}