// https://leetcode.com/problems/robot-return-to-origin/
// Robot Return to Origin
class Solution {
    public boolean judgeCircle(String moves) {
        int u=0; int l=0;
        int d=0;  int r =0;
        for(char c: moves.toCharArray()){
            if(c =='U') u++;
            if(c=='D') d++;
            if(c =='L') l++;
            if(c=='R') r++;

        }
        return (l-r == 0) && (d-u == 0);
        
    }
}