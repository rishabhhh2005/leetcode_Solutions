// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/?envType=daily-question&envId=2026-06-01
// Minimum Cost of Buying Candies With Discount
class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int ans =0;
        int ptr =n-1;
        if(n <=2){
            int res =0;
            for(int i=0;i<n;i++) res+=cost[i];
            return res;
        }
        while(ptr >=0){
            // take candy
            ans +=cost[ptr];
            if(ptr-1 >=0) ans+= cost[ptr-1];
            ptr = ptr-3;
        }
        return ans;
        
    }
}