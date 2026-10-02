class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0; 
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 1){
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;
    }
    
    public int dfs(int[][] grid, int r, int c){
        // Out of bounds or water, stop
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        } 

        // Mark cell as visited by sinking it
        grid[r][c] = 0;

        // Explore all 4 directions
        return 1 + dfs(grid, r + 1, c) + // down
        dfs(grid, r - 1, c) + // up
        dfs(grid, r, c + 1) + // right
        dfs(grid, r, c - 1); // left
    }
}

//DFS
// TIME COMPLEXITY:  O(rows * cols)
// - Every cell is visited at most once
//
// SPACE COMPLEXITY: O(rows * cols)
// - Worst case recursion depth if the entire grid is land

// I scan every cell in the grid. When I find a 1, I run DFS to sink all
// connected land cells to 0 so they are not counted again. Each DFS call
// returns 1 (current cell) plus the area from all 4 directions recursively.
// I track the maximum area found across all islands and return it.


