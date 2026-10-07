class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        // Pacific: top and left borders
        for (int r = 0; r < rows; r++) {
            pacific[r][0] = true;
            pacificQueue.offer(new int[]{r, 0});
        }

        for (int c = 0; c < cols; c++) {
            if (!pacific[0][c]) {
                pacific[0][c] = true;
                pacificQueue.offer(new int[]{0, c});
            }
        }

        // Atlantic: bottom and right borders
        for (int r = 0; r < rows; r++) {
            atlantic[r][cols - 1] = true;
            atlanticQueue.offer(new int[]{r, cols - 1});
        }

        for (int c = 0; c < cols; c++) {
            if (!atlantic[rows - 1][c]) {
                atlantic[rows - 1][c] = true;
                atlanticQueue.offer(new int[]{rows - 1, c});
            }
        }

        // BFS from both oceans
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        // Find cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights,
                     Queue<int[]> queue,
                     boolean[][] visited) {

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries
                if (nr < 0 || nr >= heights.length ||
                    nc < 0 || nc >= heights[0].length) {
                    continue;
                }

                // Already visited
                if (visited[nr][nc]) {
                    continue;
                }

                // Reverse flow: next cell must be same or higher
                if (heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}

//BFS 
//Time Complexity: O(m * n)
//Space Complexity: O(m * n)
// m is number of rows and n is number of columns