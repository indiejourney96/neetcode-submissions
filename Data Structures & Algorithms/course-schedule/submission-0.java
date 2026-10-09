class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        // 0 = not visited, 1 = visiting, 2 = completed
        int[] visited = new int[numCourses];

        // Check every course
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph,
                             int course, int[] visited) {

        // Reached a course already in the current DFS path
        if (visited[course] == 1) {
            return true;
        }

        // This course was fully checked before
        if (visited[course] == 2) {
            return false;
        }

        // Mark as currently exploring
        visited[course] = 1;

        // Explore all dependent courses
        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, visited)) {
                return true;
            }
        }

        // Finished exploring this course
        visited[course] = 2;

        return false;
    }
}

// DFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// where V is number of courses and E is number of prerequisites

//Each course is a node, and each prerequisite is a directed edge.
//You can finish all courses only if there is no cycle in this directed graph.

//A cycle means:

//Course A needs B
//B needs C
//C needs A
//So you’re stuck forever.
//We use DFS with cycle detection:

// While doing DFS, keep track of courses in the current recursion path.
//If we visit a course already in the current path → cycle found.
//If a course has no prerequisites left, it’s safe.