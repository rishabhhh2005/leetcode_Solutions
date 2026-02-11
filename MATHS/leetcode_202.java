// https://leetcode.com/problems/happy-number/solutions/3767573/easy-java-solution-two-pointers-floyds-t-ich2/
// Happy Number
class Solution {
    public boolean isHappy(int n) {
        if(n==0) return false;
        if(n==1) return true;
        
        List<Integer> l = new ArrayList<>();
        int sum =0;
        int temp =n;
        while( temp != 1 ){
            if(l.contains(temp)) return false;
              l.add(temp);
            while(temp >0){
                int digit = temp%10;
                sum = sum + digit*digit;
                temp= temp/10;
            }
            temp = sum;
            sum=0;
        }
    
        return true;   
    }
 
}
