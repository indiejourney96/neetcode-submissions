class Solution {
    public boolean isValidSudoku(char[][] board) {

        /*
         STEP 1: Check every row

         Use a HashSet to detect duplicates.
         Ignore '.' because empty cells do not count.
        */
        for(int row = 0; row < 9; row++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++){
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])){
                    return false;
                }
                seen.add(board[row][i]);
            }
        }

        /*
         STEP 2: Check every column
        */
        for(int column = 0; column < 9; column++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++){
                if (board[i][column] == '.') continue;
                if (seen.contains(board[i][column])) {
                    return false;
                }
                seen.add(board[i][column]);
            }
        }

        /*
         STEP 3: Check all 9 sub-boxes

         Box numbering:
        square 0 | square 1 | square 2
        ---------+----------+---------
        square 3 | square 4 | square 5
        ---------+----------+---------
        square 6 | square 7 | square 8
        */
        for(int square = 0; square < 9; square++){
            Set<Character> seen = new HashSet<>();

            /*
             Explore one 3x3 box
            */            
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    /*
                     Convert square number into actual board coordinates.

                     Example:
                     square = 4
                     row base = 3
                     col base = 3

                     Generates:
                     (3,3) (3,4) (3,5)
                     (4,3) (4,4) (4,5)
                     (5,3) (5,4) (5,5)
                    */
                    int row = (square / 3) * 3 + i ; 
                    int col = (square % 3) * 3 + j ;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])){
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }   
        }
        return true;
    }
}
