class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[r].length; c++){
                if (matrix[r][c] == target){
                    return true;
                }
            }
        }
        return false;
    }
}


//Because each row is sorted and the first element of each row is greater than the last element of the previous row, 
//the matrix can be treated as one sorted array. 
//I perform binary search on indices from 0 to ROWS * COLS - 1. 
//For each midpoint m, I map it back to row = m / COLS and col = m % COLS