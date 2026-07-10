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


//Because each row is sorted and each row’s first element is greater than the previous row’s last element, 
//I can first use binary search to identify the only row that could contain the target. 
//Once I find that row, I use a standard binary search within that row
