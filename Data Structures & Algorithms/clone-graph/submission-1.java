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
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>(); // To store copies of nodes
        Queue<Node> queue = new LinkedList<>();
        
        // Start BFS from the given node
        oldToNew.put(node, new Node(node.val)); // Clone the starting node
        queue.add(node);

        // BFS traversal
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            // Explore each neighbor of the current node
            for (Node neighbor : cur.neighbors){
                if (!oldToNew.containsKey(neighbor)){ // If neighbor hasn't been cloned yet
                    oldToNew.put(neighbor, new Node(neighbor.val)); // Clone the neighbor
                    queue.add(neighbor); // Add neighbor to the queue
                }
                // Link the neighbor's clone to the current node's clone
                oldToNew.get(cur).neighbors.add(oldToNew.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return oldToNew.get(node);
    }
}

//BFS
//Time Complexity: O(N + E) where N = number of nodes and E = number of edges.
//Space Complexity: O(N), for the recursion stack (DFS) and the nodeMap.

//To clone a graph, I use a BFS approach to traverse the graph level by level. I keep a map to store the clones of visited nodes to avoid duplicating work. When I visit a node, I check if it has already been cloned. If not, I create a new clone, store it in the map, and add it to the queue. For each neighbor of the current node, I link the neighbor's clone to the cloned current node. This way, each node and its neighbors are only processed once, ensuring an efficient clone.