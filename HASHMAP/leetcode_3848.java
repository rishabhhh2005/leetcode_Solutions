// https://leetcode.com/problems/digitorial-permutation/description/
// 3848. Digitorial Permutation
class Solution {
    public boolean isDigitorialPermutation(int n) {
        if(n==0)return false;
        if(n==1) return true;

        int sum =0;
        int temp=n;
        while(temp>0){
            int digit = temp%10;
            sum += getFact(digit);
            temp = temp/10;
        }
        return sum == n || isPermutations(sum,n);
        
    }
    public int getFact(int n){
        if(n <=1) return 1;
        if(n ==2) return 2;
        return n* getFact(n-1);
    }
    public boolean isPermutations(int x , int y){
        String s1 =String.valueOf(x);
        String s2 = String.valueOf(y);
        Map<Character , Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : s2.toCharArray()){
            if(!map.containsKey(c)) return false;
           
           else{
            map.put(c, map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);
           }
        }
        return map.isEmpty();

    }
}