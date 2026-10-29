
public class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;  // Starting index of the longest palindrome
        int resLen = 0;  // Length of the longest palindrome
        int n = s.length();

        // dp[i][j] = true if substring s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Start from right to left so smaller substrings are checked first
        for (int i = n - 1; i >= 0; i--) {

            // Check every ending index from i to the end
            for (int j = i; j < n; j++) {

                // First and last characters must match
                // If length <= 3, matching ends are enough
                // Otherwise, the inner substring must also be a palindrome
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || dp[i + 1][j - 1])) {

                    // Mark substring s[i...j] as a palindrome
                    dp[i][j] = true;

                    // Update the longest palindrome found
                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        // Extract the longest palindrome using its start index and length
        return s.substring(resIdx, resIdx + resLen);
    }
}

// Dynamic Programming (Bottom-Up)
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)


// I use a 2D boolean DP table where dp[i][j] indicates whether the substring from index i to j is a palindrome. If the end characters match and the inner substring is a palindrome—or the substring is at most three characters long—I mark it as a palindrome. Whenever I find a longer palindrome, I update its starting index and length. Finally, I return that substring.
