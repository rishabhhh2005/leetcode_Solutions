// https://leetcode.com/problems/task-scheduler/
// Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // This is a very good problem It will be solved by PQ + Greedy + HashMap
        // we store the frequencies of task in the map first
        Map<Character, Integer> freq= new HashMap<>();
        for(char task : tasks) freq.put(task , freq.getOrDefault(task,0) +1);

        PriorityQueue< int[]> maxHeap = new PriorityQueue<>((a,b) ->b[1] - a[1]);
        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            char key = entry.getKey();
            int freqq = entry.getValue();
            maxHeap.offer(new int[]{key,freqq});
        }
        int time =0; // total time required

        while(!maxHeap.isEmpty()){ // we will schedule tasks until our heap gets empty
            
            int window = n+1; // we will keep window to aoid doing same task again
            List<int[]> temp = new ArrayList<>();

            while(window -- > 0 && !maxHeap.isEmpty()){
                int[] curr = maxHeap.poll();
                curr[1]--;  // we do task
                time++;

                if(curr[1] > 0){ // if freq is remaining add it back
                    temp.add(curr); // stored for reinsertion
                }
            }

            for(int[] t : temp) maxHeap.offer(t); // we reinsert remaining taska after a window complete

            if(!maxHeap.isEmpty()){
                time += window+1;  // if heap still has tasks, but window not full → idle time
            }
            
        }
        return time;
    }
}