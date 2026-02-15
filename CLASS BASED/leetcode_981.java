// https://leetcode.com/problems/time-based-key-value-store/description/
// Time Based Key-Value Store
//custom class to store String and Integer
class Pair{
    String s;     // actual stored value
    int time;     // us value ka timestamp

    Pair(String s , int time){
        this.s = s;
        this.time = time;
    }
}

class TimeMap {

    // key -> us key ke saare (value, timestamp) pairs
    Map<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        // agar key pehle nahi hai to nayi list bana do
        map.putIfAbsent(key , new ArrayList<>());

        // timestamps sorted aate hain (problem guarantee)
        // isliye simply end me add kar do
        map.get(key).add(new Pair(value , timestamp));  
    }
    
    public String get(String key, int timestamp) {

        // agar key exist hi nahi karti
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        String result = "";  // yaha best possible <= timestamp store karenge

        int left = 0;
        int right = list.size() - 1;

        // binary search for floor timestamp
        while(left <= right){

            int mid = left + (right - left)/2;

            int curr_time = list.get(mid).time;

            if(curr_time == timestamp) 
                return list.get(mid).s;   // exact match mil gaya

            else if(curr_time < timestamp){
                result = list.get(mid).s; // valid candidate (<= timestamp)
                left = mid + 1;           // try to find bigger valid timestamp
            }
            else{
                right = mid - 1;          // zyada bada hai, left side jao
            }
        }

        // exact nahi mila to jo largest <= timestamp tha wo return
        return result;
    }
}
