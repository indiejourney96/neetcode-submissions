class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot){ //find for the row which target belongs to
            int row = (top + bot) / 2; 
            if (matrix[row][COLS - 1] < target){
                top = row + 1;
            } else if (matrix[row][0] > target){
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)){  // No valid row found
            return false;
        }

        int row = (top + bot) / 2; //declare again because the previous row was inside the loop. after the loop, it is no longer available.
        int l = 0, r = COLS - 1; 
        while (l <= r){ //find the specific column with the determined row.
            int m = (l + r) / 2 ; 
            if (matrix[row][m] < target){
                l = m + 1; 
            } else if (matrix[row][m] > target){
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
