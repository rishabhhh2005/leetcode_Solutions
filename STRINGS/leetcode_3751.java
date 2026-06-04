// https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/?envType=daily-question&envId=2026-06-04
// Total Waviness of Numbers in Range I
class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;

        for(int i=num1;i<=num2;i++){
            String s= String.valueOf(i);
            ans +=find(s);
            
        }
        return ans;
    }

    public int find(String s){
        int n = s.length();
        int answer=0;
        for(int i=1;i<n-1;i++){
            int curr = Integer.parseInt(String.valueOf(s.charAt(i)));
            int prev = Integer.parseInt(String.valueOf(s.charAt(i-1)));
            int next = Integer.parseInt(String.valueOf(s.charAt(i+1)));

            if(curr > prev && curr > next) answer ++;
            if( curr < prev && curr < next) answer++;
        }

        return answer;

    }
    
}