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
        Node newNode = new Node(node.val);
        Node[] visited = new Node[101];
        visited[newNode.val] = newNode;
        dfs(visited, node, newNode);
        return newNode;

    }

    private void dfs(Node[] visited, Node node, Node copyNode) {
        for (Node n : node.neighbors) {
            if (visited[n.val] == null) {
                Node newNode = new Node(n.val);
                copyNode.neighbors.add(newNode);
                visited[n.val] = newNode;
                dfs(visited, n, newNode);
            } else {
                copyNode.neighbors.add(visited[n.val]);
            }
        }
    }
}