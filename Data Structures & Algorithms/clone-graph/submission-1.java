/*
Definition for a Node.
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
        Map<Node, Node> oldToNew = new HashMap<>(); // To store copies of nodes

        return dfs(node, oldToNew);
    }

    public Node dfs(Node node, Map<Node, Node> oldToNew){
        if (node == null){
            return null;
        }

        // If we have already copied this node, return its copy
        if (oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

         // Create a copy of the node
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        // Visit each neighbor and recursively clone its graph
        for (Node neighbor  : node.neighbors){
            copy.neighbors.add(dfs(neighbor , oldToNew));
        }

        return copy;
    }
}

//DFS
//Time Complexity: O(N + E) where N = number of nodes and E = number of edges.
//Space Complexity: O(N), for the recursion stack (DFS) and the nodeMap.

//To clone a graph, I use a DFS approach to traverse the graph. I keep a map to store the clones of visited nodes to avoid duplicating work. When I visit a node, I check if it has already been cloned. If not, I create a new clone, store it in the map, and recursively clone its neighbors.