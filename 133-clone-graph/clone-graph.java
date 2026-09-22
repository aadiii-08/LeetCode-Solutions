/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map.put(node, clone);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbour : curr.neighbors) {
                Node cloneCurr = map.get(curr);
                Node cloneNeighbour;
                if (map.containsKey(neighbour)) {
                    cloneNeighbour = map.get(neighbour);
                } else {
                    cloneNeighbour = new Node(neighbour.val);
                    map.put(neighbour, cloneNeighbour);
                    q.offer(neighbour);
                }

                cloneCurr.neighbors.add(cloneNeighbour);
            }
        }

        return clone;
    }
}