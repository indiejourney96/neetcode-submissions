class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty()) return;
        int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for (int[] dir : directions){
                int r = row + dir[0];
                int c = col +dir[1];

                if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }

                queue.add(new int[] {r, c});
                grid[r][c] = grid[row][col] +1;
            }
        }
    }
}
