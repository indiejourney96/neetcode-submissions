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
        // Visit every node. If it is unvisited, we found a new
        // connected component. DFS visits every node in that component.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(graph, i, visited);
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> graph, int node,
                     boolean[] visited) {
        // Avoid visiting the same node more than once
        visited[node] = true;

        // Visit all connected neighbours
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }
}

// DFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// where V = number of vertices and E = number of edges in graph

//First, I build an adjacency list to represent the undirected graph. Then I loop through every node. Whenever I find an unvisited node, it means I have discovered a new connected component, so I increment the counter and run DFS to mark every node in that component as visited. After checking all nodes, I return the number of components.
