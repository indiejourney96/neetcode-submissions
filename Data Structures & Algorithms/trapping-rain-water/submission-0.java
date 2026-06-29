class Solution {
    public int trap(int[] height) {
        // Edge case: empty array
        if (height == null || height.length == 0){
            return 0 ;
        };
        int n = height.length;        
        int ans = 0; 

        // Calculate trapped water for every bar
        for (int i = 0; i < n; i++){
             // Assume current bar is the tallest initially
            int leftMax = height[i];
            int rightMax = height[i];

            // Find the tallest bar to the LEFT of i
            for (int j = 0; j < i; j++){
                leftMax = Math.max(leftMax, height[j]);
            }
            // Find the tallest bar to the RIGHT of i
            for (int j = i + 1; j < n ; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            /*
              water level = min(left tallest wall, right tallest wall)

              trapped water =
              water level - current bar height
            */
            ans = ans + Math.min(leftMax, rightMax) - height[i];
        }

    return ans;
    }
}
