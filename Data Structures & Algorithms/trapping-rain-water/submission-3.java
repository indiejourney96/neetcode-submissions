class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }

        int l = 0 ;
        int r = height.length - 1; 
        int ans = 0; 
        int leftMax = height[l]; 
        int rightMax = height[r];

        while (l < r){
            if (leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                ans = ans + leftMax - height[l];
            }
            else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                ans = ans + rightMax - height[r];
            }
        }
        
        return ans;
    }
}
