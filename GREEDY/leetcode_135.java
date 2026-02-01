// https://leetcode.com/problems/candy/
// Candy

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // Brute force : assign 1 candy to all kids then 
        // Traverse left -> Right (Satisfy neighbour condition)
        // Traverse Left  <- Right ( Satisfy neightbour condition)
        // until condition is met 
        boolean conditionsMet  = false;
        int candies =n ;
        int[] candyy = new int[n];
        for(int x=0;x<n;x++) candyy[x]=1;
        while(!conditionsMet){
            //left neighbour
            boolean leftfoul = false;
            for(int  i=1;i<n;i++){
                if(ratings[i] > ratings[i-1] && candyy[i] <= candyy[i-1]){
                    candyy[i]++;
                    candies++;
                    leftfoul = true;
                }
            }
            // right neighbour
            boolean rightfoul = false;
            for(int i=n-2;i>=0;i--){
                if(ratings[i] > ratings[i+1] && candyy[i] <= candyy[i+1]){
                    candyy[i]++;
                    candies++;
                    rightfoul =  true;
                }

            }
            if(!leftfoul && !rightfoul) conditionsMet = true;

        }
        return candies;
    }
}