class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Interview explanation:
        // If a and b already have the same root, they are connected.
        // Adding this edge would create a cycle, so return it.
        // Otherwise, connect their groups.
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            int rootA = find(parent, a);
            int rootB = find(parent, b);

            if (rootA == rootB) {
                return edge;
            }

            parent[rootA] = rootB;
        }

        return new int[0];
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }

        return parent[node];
    }
}

// Union-Find (Disjoint Set Union / DSU)
// Time Complexity: O(V + (E * a(V)))
// Space Complexity: O(V)
// V = number of vertices, E = number of edges, a() used for amortized complexity

// I use Union-Find to track which nodes belong to the same connected group. Initially, every node is its own group. For each edge, I find the roots of both endpoints. If the roots are the same, the nodes are already connected, so this edge creates a cycle and I return it. Otherwise, I merge the two groups by connecting their roots.
