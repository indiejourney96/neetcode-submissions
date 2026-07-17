class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int ans = 0; 
        for (int sell = 1 ; sell < prices.length ; sell++){
            
            //Found a cheaper buying day
            if (prices[sell] < prices[buy]){
                buy = sell;
            } else {
                ans = Math.max(ans, prices[sell] - prices[buy]);
            }
        } 
        return ans; 
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)

