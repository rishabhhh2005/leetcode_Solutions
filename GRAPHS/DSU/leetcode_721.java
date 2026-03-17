// https://leetcode.com/problems/accounts-merge/description/
// Accounts Merge
class DSU{
    int[] parent;
    int[] size;

    DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;
        for(int i=0;i<n;i++) size[i] = 1;
    }

    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]); // path compression
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return; // ✅ important

        if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
        }
        else{
            parent[py] = px;
            size[px] += size[py];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // 1️⃣ collect unique emails
        Set<String> emails = new HashSet<>();
        for(List<String> acc : accounts){
            for(int i=1;i<acc.size();i++){
                emails.add(acc.get(i));
            }
        }

        int n = emails.size();

        // 2️⃣ email -> index mapping
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String email : emails){
            map.put(email, index++);
        }

        // 3️⃣ email -> name mapping
        Map<String, String> emailToName = new HashMap<>();
        for(List<String> acc : accounts){
            String name = acc.get(0);
            for(int i=1;i<acc.size();i++){
                emailToName.put(acc.get(i), name);
            }
        }

        DSU dsu = new DSU(n);

        // 4️⃣ union emails
        for(List<String> acc : accounts){
            for(int i=1;i<acc.size()-1;i++){
                int e1 = map.get(acc.get(i));
                int e2 = map.get(acc.get(i+1));
                dsu.union(e1, e2);
            }
        }

        // 5️⃣ group by parent
        Map<Integer, List<String>> ans = new HashMap<>();

        for(String email : emails){
            int parent = dsu.find(map.get(email));

            ans.putIfAbsent(parent, new ArrayList<>());
            ans.get(parent).add(email);
        }

        // 6️⃣ build result
        List<List<String>> res = new ArrayList<>();

        for(List<String> list : ans.values()){
            Collections.sort(list);

            String name = emailToName.get(list.get(0));
            list.add(0, name);

            res.add(list);
        }

        return res;
    }
}