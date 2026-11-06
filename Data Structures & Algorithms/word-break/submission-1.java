class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // -1 = not calculated yet
        //  0 = false
        //  1 = true
        int[] cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);

        return dfs(s, 0, set, cache);
    }

    private boolean dfs(String s, int start, HashSet<String> set, int[] cache) {

        // Base case: successfully segmented the entire string
        if (start == s.length()) {
            return true;
        }

        // Return previously calculated result
        if (cache[start] != -1) {
            return cache[start] == 1;
        }

        // Try every possible ending position
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            // If substring exists in dictionary
            if (set.contains(word)) {

                // Check whether the remaining string can be segmented
                if (dfs(s, end, set, cache)) {
                    cache[start] = 1;
                    return true;
                }
            }
        }

        // No valid segmentation found from this position
        cache[start] = 0;

        return false;
    }
}

// DP Top-Down
// Time Complexity: O(n³)
// Space Complexity: O(n)