// https://leetcode.com/problems/assign-cookies/description/
// Assign Cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0;
        int p1= g.length-1;
        int p2= s.length-1;

        while(p1 >=0){
            if(  p2>=0 && s[p2] >= g[p1]){
                c++;
                p2--;
                p1--;
            }
            else{
                p1--;
            }
        }
        return c;
        
    }
}