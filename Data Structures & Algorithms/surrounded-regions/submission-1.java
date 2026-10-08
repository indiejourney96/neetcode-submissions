class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        // Add all border O's
        for (int r = 0; r < rows; r++) {

            if (board[r][0] == 'O') {
                board[r][0] = 'S';
                queue.offer(new int[]{r, 0});
            }

            if (board[r][cols - 1] == 'O') {
                board[r][cols - 1] = 'S';
                queue.offer(new int[]{r, cols - 1});
            }
        }

        for (int c = 0; c < cols; c++) {

            if (board[0][c] == 'O') {
                board[0][c] = 'S';
                queue.offer(new int[]{0, c});
            }

            if (board[rows - 1][c] == 'O') {
                board[rows - 1][c] = 'S';
                queue.offer(new int[]{rows - 1, c});
            }
        }

        // BFS from border O's
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                // Only process O
                if (board[nr][nc] != 'O') {
                    continue;
                }

                // Mark safe
                board[nr][nc] = 'S';

                queue.offer(new int[]{nr, nc});
            }
        }

        // Capture surrounded O's
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';

                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}

// BFS Solution 
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
//m is the number of rows and n is number of columns

//Any 'O' that is connected to the border can "escape", so it should NOT be flipped.
//Start BFS from all border 'O' cells and mark every reachable 'O' as temporary 'T' (safe).
//After that:
//leftover 'O' cells are fully surrounded → flip to 'X'
//'T' cells are safe → change back to 'O'