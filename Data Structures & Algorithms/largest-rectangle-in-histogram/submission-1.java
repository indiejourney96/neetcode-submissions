class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Instead of scanning left/right for every bar,
        // precompute the nearest smaller bar on each side.
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        Stack<Integer> stack = new Stack<>();

        // ---------- Find left boundary ----------
        for (int i = 0; i < n; i++) {
            // Default: no smaller bar on the left
            leftMost[i] = -1;

            // Remove taller/equal bars
            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // Top of stack is the nearest smaller bar
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        // ---------- Find right boundary ----------
        for (int i = n - 1; i >= 0; i--) {
            // Default: no smaller bar on the right
            rightMost[i] = n;

            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        // ---------- Same area formula as brute force ----------
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = (rightMost[i] - 1) - (leftMost[i] + 1) + 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}