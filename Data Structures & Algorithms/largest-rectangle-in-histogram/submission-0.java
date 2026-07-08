class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        // Treat every bar as the shortest bar in a rectangle
        for (int i = 0; i < n; i++) {

            int height = heights[i];

            // Expand to the right until a shorter bar is found
            int rightMost = i + 1;
            while (rightMost < n && heights[rightMost] >= height) {
                rightMost++;
            }

            // Expand to the left until a shorter bar is found
            int leftMost = i;
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }

            // Step back to the last valid positions
            rightMost--;
            leftMost++;

            // Width = right boundary - left boundary + 1
            int width = rightMost - leftMost + 1;

            // Area = height × width
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}