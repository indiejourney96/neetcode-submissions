class Solution {
    public int maxArea(int[] heights) {
        int ans = 0; 
        int l = 0 ; int r = heights.length - 1;

        while (l < r){
            int width = r - l ; 
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            ans = Math.max(ans, area);
            if (heights[l] > heights[r]){
                r--;
            } else {
                l++;
            }
        }
        return ans; 
    }
}

//Two pointers
//Time complexity: O(n2)
//Space complexity: O(1)
