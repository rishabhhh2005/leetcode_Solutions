// http://leetcode.com/problems/count-the-number-of-special-characters-i/description/?envType=daily-question&envId=2026-05-26
// Count the Number of Special Characters I
class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        int count=0;

        for( char c : word.toCharArray()) set.add(c);
        for( char c: word.toCharArray()){
            
            if( Character.isLowerCase(c) && set.contains( Character.toUpperCase(c))){
                    count++;
                    set.remove(Character.toUpperCase(c));  
            }
        }
        return count;  
    }
}