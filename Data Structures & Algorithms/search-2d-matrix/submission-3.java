class Solution { // for Search a 2D Matrix II,
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rows = 0;
        int cols = n - 1;
        while(rows < m && cols >= 0){
            if(matrix[rows][cols] > target){
                cols--;
            }else if(matrix[rows][cols] < target){
                rows++;
            }else{
                return true;
            }
        }
        return false;
    }
}

//for a different problem with time complexity, O(m + n)
//start from the top-right corner. 
//If the current value is greater than the target, I move left because all values below are larger. 
//If the current value is smaller than the target, I move down because all values to the left are smaller. 
//Each move eliminates either a row or a column
