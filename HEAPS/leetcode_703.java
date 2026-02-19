// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// 703. Kth Largest Element in a Stream
class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        //make pq size of  k
    }
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
    return pq.peek();
}
}
