class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // DFS from left and right borders
        for (int r = 0; r < rows; r++) {

            dfs(board, r, 0);

            dfs(board, r, cols - 1);
        }

        // DFS from top and bottom borders
        for (int c = 0; c < cols; c++) {

            dfs(board, 0, c);

            dfs(board, rows - 1, c);
        }

        // Capture surrounded regions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    // Not connected to border
                    board[r][c] = 'X';

                } else if (board[r][c] == 'S') {
                    // Restore safe O
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {

        // Outside board
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return;
        }

        // Not an O
        if (board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = 'S';

        // Explore 4 directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}

// DFS Solution 
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
//m is the number of rows and n is number of columns

//Only the 'O' regions that touch the border can never be surrounded, because they have a path to the outside of the board.
//So instead of trying to find surrounded regions directly, we do the opposite:

//Mark all border-connected 'O' cells as “safe” (temporary mark 'S').
//Any remaining 'O' is truly surrounded → flip it to 'X'.
//Convert the temporary 'S' back to 'O'.
