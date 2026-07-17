class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int ans = 0; 
        for (int i = 0 ; i < prices.length ; i++){
            int buy = prices[i];
            for (int j = i + 1; j < prices.length ; j++){
                int sell = prices[j];
                ans = Math.max(ans, sell - buy);
            }
        } 
        return ans; 
    }
}

//Time Complexity: O(n²)
//Space Complexity: O(1)

// The brute-force solution compares every buy day with every future sell day, which is O(n²).
// We can optimize this by scanning the array once while keeping track of the cheapest buying price seen so far. 
// For each new day, we compute the profit if we sold today and update the maximum profit.
// Since each price is visited only once, the time complexity is O(n) and the space complexity is O(1).

