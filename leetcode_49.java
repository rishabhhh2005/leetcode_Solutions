//                                                   49. Group Anagrams
//                                           https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if(!map.containsKey(key)){
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
        
    }
}