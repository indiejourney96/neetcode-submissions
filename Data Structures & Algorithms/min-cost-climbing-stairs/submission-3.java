
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Calculate the minimum cost to reach each step
        for (int i = n - 3; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }

        return Math.min(cost[0] , cost[1]);
    }
}

// Dynamic Programming (Space Optimised)
// Time Complexity: O(n)
// Space Complexity: O(1)
