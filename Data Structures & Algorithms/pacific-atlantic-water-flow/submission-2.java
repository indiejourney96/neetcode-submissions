class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++){
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < cols; c++){
            dfs(heights, 0, c, pacific);
        }

        for (int r = 0; r < rows; r++){
            dfs(heights, r, cols - 1, atlantic);
        }

        for (int c = 0; c < cols; c++){
            dfs(heights, rows - 1, c, atlantic);
        }

        List<List<Integer>> results = new ArrayList<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (pacific[r][c] && atlantic[r][c]){
                    results.add(Arrays.asList(r, c));
                }
            }
        }

        return results;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visited){
        if (visited[r][c]) return;

        visited[r][c] = true;

        int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        for (int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length){
                continue;
            } 

            if (heights[nr][nc] >= heights[r][c]){
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
