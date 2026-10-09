class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites){
            int a = p[0];
            int b = p[1];

            graph.get(b).add(a);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            if (hasCycle(graph, i, visited)){
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, int course, int[] visited){
        if (visited[course] == 1){
            return true;
        }

        if (visited[course] == 2){
            return false;
        }

        visited[course] = 1;

        for (int next : graph.get(course)){
            if (hasCycle(graph, next, visited)){
                return true;
            }
        }
        visited[course] = 2;

        return false;
    }
}
