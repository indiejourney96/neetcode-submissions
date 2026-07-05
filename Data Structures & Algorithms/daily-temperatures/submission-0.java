class Solution {
    public int[] dailyTemperatures(int[] temperatures) { 
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0 ; i < n ; i++){
            for (int j = i + 1; j < n; j++){
                // Found a warmer day
                if (temperatures[j] > temperatures[i]){
                    ans[i] = j - i;  // Number of days waited
                    break;
                }
            }
        }   
        return ans;
    }
}
