class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) -
                                      (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);   
    }
}

//Sorting 
//Time Complexity: O(n log n)
//Space Complexity: O(1)

//Distance = sqrt((x1 - x2)^2 + (y1 - y2)^2))
//Distance^2 = (x1 - x2)^2 + (y1 - y2)^2
//Distance^2 = (x1 - 0)^2 + (y1 - 0)^2
//Distance^2 = (x1)^2 + (y1)^2