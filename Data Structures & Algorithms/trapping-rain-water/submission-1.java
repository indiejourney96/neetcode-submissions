class Solution {
    public int trap(int[] height) {

        // Edge case: empty array
        if (height == null || height.length == 0) {
            return 0;
        }

        // Two pointers starting from both ends
        int l = 0;
        int r = height.length - 1;

        // Highest wall seen so far from the left and right
        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;

        while (l < r) {

            /*
             Always process the side with the smaller maximum wall.
             Why?
             The smaller wall determines the water level.
            */
            if (leftMax < rightMax) {
                l++;
                // Update tallest wall on the left
                leftMax = Math.max(leftMax, height[l]);
                // Water trapped at current bar
                res += leftMax - height[l];

            } else {
                r--;
                // Update tallest wall on the right
                rightMax = Math.max(rightMax, height[r]);
                // Water trapped at current bar
                res += rightMax - height[r];
            }
        }
        return res;
    }
}