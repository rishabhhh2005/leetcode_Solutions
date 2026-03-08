// https://leetcode.com/problems/network-delay-time/description/
// Dijkstra's Algorithm
class Solution { // DIJKSTRA ALGO EASY PEAZYYY
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)  adj.add( new ArrayList<>());
        for(int[]t : times){
            int u= t[0];
            int v =t[1];
            int w = t[2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,w)));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int[] distance = new int[n+1];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[0]= -1; //unused node
        distance[k] =0;
        pq.offer( new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node= curr[0];
            int curr_dist = curr[1];
            for(ArrayList<Integer> neighList : adj.get(node)){
                int neigh = neighList.get(0) ;
                int neigh_dist = neighList.get(1);
                if( distance[neigh] > neigh_dist + curr_dist){
                    distance[neigh] = neigh_dist + curr_dist;

                     pq.offer(new int[]{neigh,distance[neigh]});
                }
               

            }
        }
        int max = distance[0];
        for(int x : distance) max = Math.max(max,x);
        return max == Integer.MAX_VALUE?-1:max;

        
    }
}