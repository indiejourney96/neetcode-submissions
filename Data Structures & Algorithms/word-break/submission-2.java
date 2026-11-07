class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = Can the substring s[i...n-1] be segmented?
        boolean[] dp = new boolean[n + 1];

        // Base case: An empty string can always be segmented
        dp[n] = true;

        // Work backwards from the last character
        for (int i = n - 1; i >= 0; i--) {
            
            // Try every possible ending position
            for (int j = i + 1; j <= n; j++){  

                String word = s.substring(i, j);

                // Check if this substring is a dictionary word
                // and whether the remaining suffix can be segmented
                if (set.contains(word) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// DP Bottom-Up
// Time Complexity: O(n³)
// Space Complexity: O(n)