// https://leetcode.com/problems/fruit-into-baskets/
// Fruit into Baskets

class Solution {
    public int totalFruit(int[] fruits) {
        //We will solve this by Sliding Window + HashMap + 2 Pointers
        int n = fruits.length;
        int left=0;
        int right =0;
        int currlen, maxlen =0;
        Map<Integer , Integer > map = new HashMap<>();
        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            while(map.size() >2){
                    int toremove = fruits[left];
                    map.put(toremove , map.get(toremove)-1);
                    if(map.get(toremove) == 0){
                        // if its count reaches 0 , completely remove it
                       map.remove(toremove);
                        
                    }  
                    left ++;
                }
            right++;
            currlen = right - left;
            maxlen = Math.max(maxlen, currlen);
            
        }
        return maxlen;
        
    }
}