class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0; 
        int time = 0; 

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == 1){
                    fresh++;
                }
                if (grid[r][c] == 2){
                    queue.offer(new int[]{r , c});
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (fresh > 0 && !queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < grid.length &&
                        c >= 0 && c < grid[0].length &&
                        grid[r][c] == 1){
                            grid[r][c] = 2;
                            queue.offer(new int[]{r,c});
                            fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

//BFS
//Time Complexity: O(m * n)
//Space Complexity: O(m * n)

//I use BFS because the rotting happens level by level, where each BFS level represents one minute. First, I count all fresh fruits and add all initially rotten fruits to the queue."
//"For each minute, I process the current size of the queue. For every rotten fruit, I check its four adjacent cells. If a cell contains a fresh fruit, I make it rotten, add it to the queue, and decrease the fresh count."
//"After processing one level, I increment the time. When there are no fresh fruits left, I return the time. If the queue becomes empty while fresh fruits still remain, those fruits cannot be reached, so I return -1.
