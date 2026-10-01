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
        // Out of bounds or water, stop
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        } 

        // Mark cell as visited by sinking it
        grid[r][c] = '0';

        // Explore all 4 directions
        dfs(grid, r + 1, c); // down
        dfs(grid, r - 1, c); // up
        dfs(grid, r, c + 1); // right
        dfs(grid, r, c - 1); // left
    }
}


// DFS:
// TIME COMPLEXITY:  O(rows * cols)
// - Every cell is visited at most once
//
// SPACE COMPLEXITY: O(rows * cols)
// - Worst case recursion depth if the entire grid is land

// I scan every cell in the grid. When I find a '1', I increment the island count and run DFS to sink all connected land cells to '0' so they are not counted again. Each DFS call explores all 4 directions recursively until it hits water or a boundary. The total count at the end is the number of islands.

