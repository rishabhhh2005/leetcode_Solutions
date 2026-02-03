// https://leetcode.com/problems/last-stone-weight/
// Last Stone Weight
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) pq.offer(s);

        while(pq.size() >1){
            int max = pq.poll();
            int smax = pq.poll();
            int newstone = max-smax;
            pq.offer(newstone);
        }
        return pq.poll();
        
    }
}