class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; 
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r  < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == '1'){
                    count++;
                    dfs(grid , r , c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        Queue<int[]> queue = new LinkedList<>();

        grid[r][c] = '0';
        queue.offer(new int[]{r, c});
        int[][] directions ={
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0]; int col = curr[1];

            for (int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
     

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == '0'){
                continue;
            }

            grid[newRow][newCol] = '0';
            queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}
