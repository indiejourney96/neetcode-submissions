class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Build the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // b -> a means take b before a
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            graph.get(b).add(a);
        }

        // 0 = unvisited, 1 = visiting, 2 = completed
        int[] visited = new int[numCourses];

        // Store courses in DFS finishing order
        List<Integer> order = new ArrayList<>();

        // Check every course for a cycle
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited, order)) {
                return new int[0];
            }
        }

        // Reverse the finishing order to get a valid course order
        Collections.reverse(order);

        // Convert the list to an array
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    private boolean hasCycle(List<List<Integer>> graph,
                             int course,
                             int[] visited,
                             List<Integer> order) {

        // A course in the current DFS path means a cycle
        if (visited[course] == 1) {
            return true;
        }

        // Already fully explored this course
        if (visited[course] == 2) {
            return false;
        }

        // Mark as currently exploring
        visited[course] = 1;

        // Explore neighboring courses
        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, visited, order)) {
                return true;
            }
        }

        // Mark as completed
        visited[course] = 2;

        // Add after exploring neighbors
        order.add(course);

        return false;
    }
}
