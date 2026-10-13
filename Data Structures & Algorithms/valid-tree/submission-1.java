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
        Queue<int[]> queue = new LinkedList<>();

        // Start BFS from node 0; store [node, parent]
        queue.offer(new int[] {0, -1});
        visited[0] = true;

        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            int node = curr[0];
            int parent = curr[1];

            for (int next : graph.get(node)){
                
                // Ignore the node we came from
                if (next == parent){
                    continue;
                }

                // Revisied another node: cycle found
                if (visited[next]){
                    return false;
                }

                // Mark visited when adding to the queue
                visited[next] = true;
                queue.offer(new int[]{next, node});

            }
        }

        // Every node must be connected
        for (int i = 0 ; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }

        return true;
    }
}


// BFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// V = number of nodes, E = number of edges

//GRAPH VALID TREE — BFS

// 1. If edges.length != n - 1 → false
// 2. Build undirected graph
// 3. Queue stores {node, parent}
// 4. Start BFS from node 0
// 5. For each neighbor:
//    - If neighbor == parent → skip
//    - If already visited → cycle → false
//    - Otherwise mark visited and enqueue
// 6. If any node is unvisited → false
// 7. Otherwise → true