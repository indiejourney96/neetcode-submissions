class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;

        for (int i = 0 ; i < heights.length ; i++){
            for (int j = i + 1; j < heights.length ; j++){
                int height = Math.min(heights[i], heights[j]);
                int width = j - i ; 
                int area = height * width; 
                ans = Math.max(ans,area);
            }
        }
        return ans;
    }
}
