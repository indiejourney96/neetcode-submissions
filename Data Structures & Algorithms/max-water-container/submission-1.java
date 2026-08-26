class Solution {
    public int maxArea(int[] heights) {
        int ans = 0; 

        for (int i = 0 ; i < heights.length ; i++){
            for (int j = i + 1 ; j < heights.length ; j++){
                int width = j - i ; 
                int height = Math.min(heights[i] , heights[j]);
                int area = width * height;
                ans = Math.max(ans, area);
            }
        }
        return ans; 
    }
}

//Brute Force
//Time complexity: O(n2)
//Space complexity: O(1)