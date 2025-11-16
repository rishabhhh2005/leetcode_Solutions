// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// Cheapest Flights Within K Stops
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // SIMPLE BFS
        //pq -> node, stopsleft , money
            Queue<int[]> q =new LinkedList<>();
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int []f : flights){
                int d1 = f[0];
                int d2 = f[1];
                int m = f[2];
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(d2);
                curr.add(m);
                adj.get(d1).add(curr);
            }

            q.offer(new int[]{src, 0 , 0});
            int[] distance = new int[n];
            Arrays.fill(distance  , Integer.MAX_VALUE);
            distance[src] =0;

            while(!q.isEmpty()){
                int[]curr = q.poll();
                int node = curr[0];
                int stops = curr[1];
                int money = curr[2];
                if(stops >k) continue;

                for( ArrayList<Integer> a : adj.get(node)){
                    int neigh = a.get(0);
                    int money_to_neigh = a.get(1);

                    if(money_to_neigh + money < distance[neigh] && stops<=k){
                        distance[neigh] = money_to_neigh + money;
                        q.offer( new int[]{neigh , stops+1  , money_to_neigh+money});
                        
                    }
                    
                }
            }
            if(distance[dst] ==  Integer.MAX_VALUE) return -1;
            return distance[dst];

        
    }
}