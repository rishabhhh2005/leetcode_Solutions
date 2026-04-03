// https://leetcode.com/problems/clone-graph/submissions/1967734102/?envType=problem-list-v2&envId=oizxjoit
// Clone Graph
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        // agar already cloned hai
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        // clone create karo
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        // neighbors clone karo
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }
        
        return clone;
    }
}