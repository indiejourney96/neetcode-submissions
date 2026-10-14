class Solution {
    public int countComponents(int n, int[][] edges) {
        // Build an undirected graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            // Undirected: both nodes connect to each other
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // Interview explanation:
        // If a node is unvisited, we found a new component.
        // Increase the counter and use BFS to visit that component.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                bfs(graph, i, visited);
            }
        }

        return components;
    }

    private void bfs(List<List<Integer>> graph, int start,
                     boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();

        // Mark visited when adding to the queue
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Visit all connected neighbours
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}

// BFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// where V = number of vertices and E = number of edges in graph

//First, I build an adjacency list to represent the undirected graph. Then I loop through every node. If a node is unvisited, I have found a new connected component, so I increment the counter and run BFS using a queue. BFS visits all nodes connected to that starting node and marks them as visited. After checking every node, I return the number of connected components.