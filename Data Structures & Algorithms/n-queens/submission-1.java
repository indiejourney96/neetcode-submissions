class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n]; // Initialize board
        for (int i = 0 ; i < n; i++){ // Fill with '.'
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(0, board, res);  // Start backtracking from row 0
        return res;
    }

    public void backtrack(int r, char[][] board, List<List<String>> res){
        if (r == board.length){  // Base case: all queens are placed
            List<String> copy = new ArrayList<>();
            for (char[] row : board){ // Create a copy for result
                copy.add(new String(row));
            }
            res.add(copy); // Add to results
            return ;
        }
        for (int c = 0; c < board.length; c++){ // Try each column
            if (isSafe(r, c, board)){ // Check if safe to place queen
                board[r][c] = 'Q'; // Place queen
                backtrack(r + 1, board, res); // Recurse to next row
                board[r][c] = '.';  // Remove queen (backtrack)
            }
        }
    }

    public boolean isSafe(int r, int c, char[][] board){
        // Check for queen in same column
        for (int i = r - 1; i >= 0; i--){ 
            if (board[i][c] == 'Q') return false;
        }
        // Check for queen in left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q') return false;
        }
        // Check for queen in right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++){
            if (board[i][j] == 'Q') return false;
        }
        return true;  // Safe to place a queen
    }
}

//Backtrack 
//Time Complexity: O(n!)
//Space Complexity: O(n2)

//I use backtracking to solve the N-Queens problem. I start by filling the board with '.', and then recursively try placing a queen in each column of the current row. I check for conflicts in the same function, and if safe, place the queen and recurse to the next row. When all queens are placed, I copy the board to the result list. If placing a queen conflicts with others, I backtrack by removing it.

//Why doesn't isSafe() check the current row?
//Because backtrack() guarantees that we're only placing one queen per row.
