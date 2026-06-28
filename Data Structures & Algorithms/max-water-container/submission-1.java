class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1; 
        int ans = 0; 

        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int area = height * width;
            ans = Math.max(ans, area);
            if (heights[l] <= heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
