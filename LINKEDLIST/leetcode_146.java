                                                                   //146. LRU Cache
                            //https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150

class LRUCache {
    Map<Integer , Integer> map = new LinkedHashMap<>();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity =capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        //lInkedHashMap true for maintaining LRU order
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) { 
        if(map.containsKey(key)) {
         
            map.put(key, value);
            return;
        }
        if(map.size() == capacity){

                Integer lrukey = map.entrySet().iterator().next().getKey();//returns first key in map
                map.remove(lrukey);
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */