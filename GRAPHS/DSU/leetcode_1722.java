// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
// Minimize Hamming Distance After Swap Operations
class DSU{
    int[] parent;
    int[]size;

    DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
             parent[i] = i;
             size[i] =1;
        }
    }

    public int find(int x){
        if (parent[x] == x ) return x;
        return parent[x] = find(parent[x]); // path compression
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if(px != py){
            if( size[px] < size[py]){
                parent[px] = py;
                size[py] += size[px];
            }
            else{
                parent[py] = px;
                size[px]+= size[py];
            }
        }
    }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        DSU dsu = new DSU(n);

        // union
        for(int[] swap : allowedSwaps){
            dsu.union(swap[0], swap[1]);
        }

        // grouponggg indices
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for(int i = 0; i < n; i++){
            int parent = dsu.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        // ...process each group
        int mismatch = 0;

        for(List<Integer> group : groups.values()){

            Map<Integer, Integer> freq = new HashMap<>();

            for(int idx : group){
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            for(int idx : group){
                if(freq.getOrDefault(target[idx], 0) > 0){
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    mismatch++;
                }
            }
        }

        return mismatch;
    }
}