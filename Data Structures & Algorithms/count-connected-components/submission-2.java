class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int components = 0; 

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                components++;
                dfs(graph, i, visited);
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited){
        visited[node] = true;

        for (int next : graph.get(node)){
            if (!visited[next]){
                dfs(graph, next, visited);
            }
        }
    }
}
