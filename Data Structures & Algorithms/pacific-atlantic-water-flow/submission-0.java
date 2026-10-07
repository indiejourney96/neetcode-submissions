class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Start DFS from Pacific borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Start DFS from Atlantic borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }

        // Cell can reach both oceans
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

    private void dfs(int[][] heights, int r, int c,
                     boolean[][] visited) {

        // Already visited
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Check boundaries
            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow: next cell must be same or higher
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}

//DFS 
//Time complexity: O(m * n)
//Space complexity: O(m * n)
//where m is number of rows and n is number of columns

//I use reverse graph traversal with DFS. Instead of starting from every cell and checking whether water can reach both oceans, I start from the Pacific and Atlantic borders and work backwards."

//"Normally water flows from higher or equal height to lower height. Since I'm traversing backwards from the ocean, I can move from a cell to a neighboring cell only when the neighbor's height is greater than or equal to the current cell."

//"I run DFS once from the Pacific borders and once from the Atlantic borders, using two visited matrices. Finally, any cell visited by both DFS traversals can flow to both oceans.