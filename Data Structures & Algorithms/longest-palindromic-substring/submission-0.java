
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";  // Store the longest palindrome found
        int resLen = 0;   // Store its length

        // Try every starting index
        for (int i = 0; i < s.length(); i++) {

            // Try every ending index
            for (int j = i; j < s.length(); j++) {
                // Check whether substring s[i...j] is a palindrome
                int l = i;
                int r = j;

                // Compare characters from both ends, moving inward
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                // If pointers meet or cross, the substring is a palindrome
                // Update the result only if this substring is longer
                if (l >= r && resLen < (j - i + 1)) {
                    res = s.substring(i, j + 1);
                    resLen = j - i + 1;
                }
            }
        }

        return res; // Return the longest palindrome found
    }
}

// Brute Force
// Time Complexity: O(n^3)
// Space Complexity: O(n)


// I use two nested loops to generate every possible substring. For each substring, I use two pointers, l and r, to compare characters from the left and right ends. If the pointers meet or cross, the substring is a palindrome. If its length is greater than the current longest palindrome, I update the result. Finally, I return the longest palindrome found.
