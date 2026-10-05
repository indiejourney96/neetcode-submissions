class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    queue.add(new int[]{i , j});
                }
            }
        }
        if (queue.isEmpty()) return;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for (int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];

                if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }

                queue.add(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}


// Multi-source BFS:
// Time: O(m * n) - each cell is added to the queue at most once.
// Space: O(m * n) - the queue can contain up to m * n cells.

// Start BFS from all treasure cells at the same time.
// BFS expands level by level, so the first time we reach an empty room,
// we have found its shortest distance to the nearest treasure.

// We don't need a separate visited array because once an empty room is
// updated from INF to a distance, it will not be processed again.

