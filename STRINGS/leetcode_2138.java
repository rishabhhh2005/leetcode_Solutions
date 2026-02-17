// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/ 
// Divide a String Into Groups of Size k
class Solution {
     String[] res ;
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        if(n%k == 0) res = new String[n/k];
        else res =new String[n/k +1];
        StringBuilder sb = new StringBuilder();
        int temp=k;
        int index=0;
        for(char c : s.toCharArray()){
            if(temp == 0){
                res[index++] = sb.toString();
                temp =k ;
                sb.setLength(0);
            }
            sb.append(c);
            temp--;
        }
        if(sb.length() >0){
            while(temp >0) {
                sb.append(fill);
                temp--;
            }
            res[index++] = sb.toString();
        }
        return res;
    }


}