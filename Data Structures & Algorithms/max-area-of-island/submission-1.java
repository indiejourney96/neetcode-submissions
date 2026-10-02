class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; 
        int rows = grid.length;
        int cols = grid[0].length;

        // Visit every cell in the grid
        for (int r = 0 ; r < rows ; r++){
            for (int c = 0; c < cols ; c++){
                // Found unvisited land, new island found
                if (grid[r][c] == 1){ 
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;

        // Mark starting cell as visited and add to queue
        grid[r][c] = 0;
        queue.offer(new int[]{r, c});

        // 4 directions: down, up, right, leftt
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            };

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            // Count current cell
            area++;

            // Explore all 4 directions
            for (int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Skip if out of bounds or water
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
                    continue;
                }

                // Mark as visited and add to queue
                grid[newRow][newCol] = 0;
                queue.offer(new int[] {newRow, newCol});
            }
        }   
        return area;     
    }
}

// BFS:
// TIME COMPLEXITY:  O(rows * cols)
// - Every cell is visited at most once
//
// SPACE COMPLEXITY: O(rows * cols)
// - BFS queue holds at most the size of the largest BFS frontier

// I scan every cell in the grid. When I find a 1, I run BFS to sink all
// connected land cells to 0 so they are not counted again. BFS uses a
// queue to explore all 4 directions level by level. I increment the area
// counter each time I poll a cell from the queue. I track the maximum
// area found across all islands and return it.
