class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; 
        int rows = grid.length;
        int cols = grid[0].length;

        // Visit every cell in the grid
        for (int r = 0 ; r < rows ; r++){
            for (int c = 0; c < cols ; c++){
                // Found unvisited land, new island found
                if (grid[r][c] == '1'){ 
                    count++;
                    dfs(grid, r, c);  // Sink entire island
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        Queue<int[]> queue = new LinkedList<>();

        // Mark starting cell as visited and add to queue
        grid[r][c] = '0';
        queue.offer(new int[]{r, c});

        // 4 directions: down, up, right, leftt
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            };

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            // Explore all 4 directions
            for (int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Skip if out of bounds or water
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == '0') {
                    continue;
                }

                // Mark as visited and add to queue
                grid[newRow][newCol] = '0';
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}


// BFS:
// TIME COMPLEXITY:  O(rows * cols)
// - Every cell is visited at most once
//
// SPACE COMPLEXITY: O(rows * cols)
// - BFS queue holds at most the size of the largest BFS frontier
// - Much better than DFS worst case in practice

// I scan every cell in the grid. When I find a '1', I increment the island count and run BFS to sink all connected land cells to '0' so they are not counted again. BFS uses a queue to explore all 4 directions level by level until no more land cells are reachable. The total count at the end is the number of islands.

