//                                          LeetCode Problem 451: Sort Characters By Frequency
//                                       https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
       Map<Character , Integer> map = new HashMap<>();
       char[] str = s.toCharArray();
       StringBuilder result = new StringBuilder();

       for( char c : str){
        map.put(c , map.getOrDefault(c,0)+1);
       }

       while(!map.isEmpty()){
        int max = Collections.max(map.values());
        char toremove ='\0';

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if(value == max){
                
                for(int i=0;i<value;i++){
                    result.append(key);
                    
                }
                toremove =key;
                break;

            }
            
            
        }
        map.remove(toremove);
        
        

       }
       return result.toString();
        
    }
}