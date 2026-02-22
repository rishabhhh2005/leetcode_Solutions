// https://leetcode.com/problems/maximum-xor-after-operations/description/
// 3849. Maximum XOR After Operations
class Solution {
    public String maximumXor(String s, String t) {
        
        // t me kitne 0 aur 1 hain count kar rahe hain
        int zerocount = 0;
        int onecount = 0;
        
        for(char c : t.toCharArray()){
            if(c == '0') zerocount++;
            else onecount++;
        }

        // ye final XOR result store karega
        StringBuilder res = new StringBuilder();
        
        // s ko left se right traverse karte hain
        for(char c : s.toCharArray()){
            
            if(c == '0'){
                // agar s[i] = 0 hai
                // to XOR = 1 tab milega jab t me 1 available ho
                if(onecount >= 1){
                    onecount--;          // ek 1 use kar liya
                    res.append('1');     // XOR result = 1
                }
                else{
                    zerocount--;         // majboori me 0 use karna padega
                    res.append('0');     // XOR result = 0
                }

            }
            else{
                // agar s[i] = 1 hai
                // to XOR = 1 tab milega jab t me 0 available ho
                if(zerocount >= 1){
                    zerocount--;         // ek 0 use kar liya
                    res.append('1');     // XOR result = 1
                }
                else{
                    onecount--;          // majboori me 1 use karna padega
                    res.append('0');     // XOR result = 0
                }
            }
        }

        // res already XOR result hai, isliye directly return kar rahe hain
        return res.toString();
    }
}