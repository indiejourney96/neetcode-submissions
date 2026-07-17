class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int left = 0;
        Set<Character> seen = new HashSet<>();

        // Try every possible starting index
        for (int right = 0; right < s.length(); right++) {

            // Duplicate found
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left)); // Remove characters from the left
                left++;
            }
            // Character is unique so far
            seen.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}


// Brute force (O(n²))
// Start from every index.
// Use a HashSet to detect duplicates.
// Expand until a duplicate appears.

// Optimization
// Notice that when moving from one starting index to the next, much of the work is repeated.
// Instead of rebuilding the HashSet each time, keep a single window and adjust its left boundary when a duplicate is found.
// This naturally leads to the sliding window solution with O(n) time. 
// This transition is easy to explain because the optimized solution reuses the same core idea—maintaining 
// a set of unique characters—but avoids restarting from scratch for every starting position.