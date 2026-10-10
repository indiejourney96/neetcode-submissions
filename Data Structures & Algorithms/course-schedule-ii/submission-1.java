class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Create an empty adjacency list for every course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: b -> a means take b before a
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            graph.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Start with courses that have no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        // Process courses whose prerequisites are satisfied
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            for (int next : graph.get(course)) {
                indegree[next]--;

                // All prerequisites are now satisfied
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If not all courses were taken, a cycle exists
        if (order.size() != numCourses) {
            return new int[0];
        }

        // Convert the course order to an array
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }
}

// BFS (Kahn's Algorithm)
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// where V is number of courses and E is number of prerequisites

// Treat each course as a node and each prerequisite as a directed edge.
// If a course has no prerequisites, it can be taken immediately.

// Kahn's Algorithm repeatedly takes courses with zero prerequisites.
// When we finish a course, reduce the indegree of its dependent courses.

// If all courses can be taken, return their ordering.
// If some courses cannot be taken, a cycle exists; return an empty array.
