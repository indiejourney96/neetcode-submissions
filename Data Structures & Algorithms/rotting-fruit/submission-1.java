class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0; 
        int time = 0;

        for (int r = 0 ; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == 1){
                    fresh++;
                }
                if (grid[r][c] == 2){
                    queue.offer(new int[]{r , c});
                }
            }
        }
        int[][] directions ={
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while (fresh > 0 && !queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
