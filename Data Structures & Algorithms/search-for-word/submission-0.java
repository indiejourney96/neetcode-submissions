class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                // If the current cell matches the first character of the word,
                // start the DFS search from this cell
                if (backtrack(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false; //if no valid path, return false
    }

    public boolean backtrack(char[][] board, String word, int r, int c, int index){
        //Found the whole word 
        if (index == word.length()){
            return true;
        }

        //Out of bounds or mismatch
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != word.charAt(index)){
            return false;
        }

        //Mark current cell as visited with #
        char temp = board[r][c];
        board[r][c] = '#';

        //Try 4 directions
        boolean found = 
        backtrack(board, word, r + 1, c, index + 1) || 
        backtrack(board, word, r - 1, c, index + 1) ||
        backtrack(board, word, r, c + 1, index + 1) || 
        backtrack(board, word, r, c - 1, index + 1);

        //Backtrack by restoring the original character at the current cell
        board[r][c] = temp;

        return found;
    }
}

//Backtrack
//Time complexity: O(m * 4^n)
//Space complexity: O(n)

// m = number of cells in the board 
// n = length of word


// I use DFS + backtracking starting from every cell in the board.
// At each cell, I check if it matches the current character in the word,
// explore all 4 directions, mark the cell visited so it cannot be reused,
// and restore it after the search. When index == word.length(), the word is found

