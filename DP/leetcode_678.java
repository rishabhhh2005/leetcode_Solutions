// https://leetcode.com/problems/valid-parenthesis-string/description/
// Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        //for  * we need to try every possible way
        // at every index we need to check if rightopen > leftopen
        // if that happens we must immediatley retrurn false;

        //Recursion will give TLE thats why we used 3D DP because there are 3 states (index, left,right)
        if(s.length() == 0 ) return true;
        Boolean[][][] memo = new Boolean[s.length()][s.length()+1][s.length()+1];
        return recursion(0,s,0,0, memo);
        
    }
    public boolean recursion(int index ,String s, int leftopen , int rightopen, Boolean memo [][][]){
        if(rightopen > leftopen) return false;
        if(index >= s.length()) return leftopen == rightopen;
        if(memo[index][leftopen][rightopen] != null) return memo[index][leftopen][rightopen];
         if( s.charAt(index) == '*'){
            boolean treatasLeft = recursion(index +1 , s, leftopen +1 , rightopen, memo);
            boolean treatasright = recursion(index+1 , s, leftopen, rightopen+1, memo);
            boolean treatasempty = recursion(index+1,s,leftopen, rightopen, memo);

            return memo[index][leftopen][rightopen] = treatasLeft || treatasright || treatasempty ;
            //if any of the recursion gives false return false;
            //Agar Koi bhi ek true hai to Kaam chaljayega
        }
        if(s.charAt(index) == '(') leftopen++;
        if(s.charAt(index) == ')') rightopen++;
          
        return memo[index][leftopen][rightopen] = recursion(index+1,s,leftopen,rightopen, memo);

    }
}