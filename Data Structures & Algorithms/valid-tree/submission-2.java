class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1){
            return false;
        }

        // Build an undirected graph 
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        // Check for cycles, starting from node 0 
        if (hasCycle(graph, 0, -1, visited)){
            return false;
        }

        // Every node must be connected
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, int node, int parent, boolean[] visited){
        
        visited[node] = true;

        for (int next : graph.get(node)){
            // Ignore the node we came from 
            if (next == parent){
                continue;
            }

            // Revisited another node: cycle found
            if (visited[next]){
                return true;
            }

            if (hasCycle(graph, next, node, visited)){
                return true;
            }
        }
        
        return false;
    }
}


//DFS 
//Time Complexity: O(V + E)
//Space Complexity: O(V + E)
// V = number vertices, E = number of edges 

// A graph is a valid tree if:
// i. No cycles — you must not revisit a node that was already visited, except the parent node you came from.
// ii. All nodes must be connected — starting DFS from node 0 must reach every node.