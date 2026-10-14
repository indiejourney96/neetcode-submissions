class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // Build an undirected graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Interview explanation:
        // Process edges in input order. If a path already exists
        // between a and b, adding this edge creates a cycle.
        // Return the edge immediately; it is the last such edge.
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (dfs(graph, a, b, visited)) {
                return edge;
            }

            // No path exists yet, so safely add this edge
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return new int[0];
    }

    private boolean dfs(List<List<Integer>> graph, int node, int target, boolean[] visited) {
        if (node == target) {
            return true;
        }

        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                if (dfs(graph, next, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

// DFS
// Time Complexity: O(E * (V + E))
// Space Complexity: O(V + E)
// where V = number of vertices and E = number of edges

//I process the edges one by one in their original order. Before adding an edge, I use DFS to check whether a path already exists between its two endpoints. If a path exists, adding this edge would create a cycle, so I return that edge. Otherwise, I add it to the graph and continue. Since I process edges in input order, the first edge that creates a cycle is the last redundant edge in the input.