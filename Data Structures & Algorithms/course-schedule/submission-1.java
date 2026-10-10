class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        Queue<Integer> queue = new LinkedList<>();

        // Start with courses that have no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        // Process courses whose prerequisites are satisfied
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : graph.get(course)) {
                indegree[next]--;

                // All prerequisites are now satisfied
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If every course can be taken, there is no cycle
        return completed == numCourses;
    }
}

// BFS (Kahn's Algo)
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// where V is number of courses and E is number of prerequisites

//Treat each course as a node and each prerequisite as a directed edge.
//If a course has no prerequisites, it can be taken immediately.

//Kahn's Algorithm repeatedly takes courses that have zero prerequisites.
//When we finish a course, we remove its dependency effect from other courses.

//If all courses can be taken this way - no cycle, return true
//If some courses are never taken - cycle exists, return false
