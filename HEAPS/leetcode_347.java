// https://leetcode.com/problems/top-k-frequent-elements/description/
// Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int  n= nums.length;
         Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                            (a,b) -> map.get(a) - map.get(b)
                            );
        for(int x : map.keySet()){
            pq.offer(x);
            if(pq.size() > k){
                pq.poll();
            }
        
        }
        int[] res = new int[k];
        int idx=0;
        for(int i=0;i<k;i++) res[idx++]= pq.poll();
        return res;
        
    }
}