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
        // Return that edge immediately.
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (bfs(graph, a, b, visited)) {
                return edge;
            }

            // No path exists yet, so safely add this edge
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return new int[0];
    }

    private boolean bfs(List<List<Integer>> graph, int start,
                        int target, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == target) {
                return true;
            }

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }
}


// BFS
// Time Complexity: O(E * (V + E))
// Space Complexity: O(V + E)
// where V = number of vertices and E = number of edges

//I process the edges in their original order. Before adding each edge, I use BFS to check whether its two endpoints are already connected. If BFS finds a path, adding this edge would create a cycle, so I return it. Otherwise, I add the edge to the graph and continue. This ensures that I return the edge that first creates a cycle in the given input order