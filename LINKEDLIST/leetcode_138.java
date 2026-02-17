// https://leetcode.com/problems/copy-list-with-random-pointer/
// Copy List with Random Pointer
class Solution {
    HashMap<Node , Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);

        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
        
    }
}
