// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// Number of Substrings Containing All Three Characters

class Solution {
    public int numberOfSubstrings(String s) {
          // ye question thoda tricky hai.. ham har index par
        // 'a', 'b', aur 'c' ka last seen index track karte hain.
        // jab bhi teeno characters mil jaate hain,
        // to leftmost index (min of a, b, c) tak ke saare starting points
        // se valid substrings ban sakte hain.
        // isliye har step par (leftmost + 1) substrings add kar dete hain.
        int a=-1, b=-1, c=-1;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch == 'a') a= i;
            if(ch == 'b') b=i;
            if(ch == 'c') c =i;

            if(a != -1 && b!= -1 && c!= -1){
                int leftmost = Math.min(a, Math.min(b,c)); // take the leftmost character's index and +1 krdo because array me indexing 0 se hoti h to
                count = count + leftmost +1;

            }
        }
        return count;
        
    }
}