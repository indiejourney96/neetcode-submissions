class Solution {
    public String minWindow(String s, String t) {

        String ans = "";

        // Try every starting position
        for (int i = 0; i < s.length(); i++) {

            // Frequency of current window
            Map<Character, Integer> window = new HashMap<>();

            // Expand window to the right
            for (int j = i; j < s.length(); j++) {

                char c = s.charAt(j);

                // Add current character
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }

                // Check whether current window contains t
                if (isValid(window, t)) {

                    String current = s.substring(i, j + 1);

                    if (ans.equals("") || current.length() < ans.length()) {
                        ans = current;
                    }

                    // Larger windows from the same start
                    // can never be shorter
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isValid(Map<Character, Integer> window, String t) {

        Map<Character, Integer> need = new HashMap<>();

        // Count characters needed
        for (char c : t.toCharArray()) {

            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        // Check whether window has enough characters
        for (char c : need.keySet()) {

            if (!window.containsKey(c)) {
                return false;
            }

            if (window.get(c) < need.get(c)) {
                return false;
            }
        }

        return true;
    }
}


// I'm going to brute-force every possible starting position. 
// For each start, I'll keep expanding the window until it contains all the characters in t.
// Once it does, I'll update the shortest answer and stop expanding because any larger window
//  from the same start will only be longer.

// The brute-force solution tries every starting position and expands the window until the end of the string. 
// For each window, I verify whether it contains all the required characters from t. 
// Strictly speaking, the complexity is O(n² × |t|) because of the validation step. 
// Since the character set is fixed in this problem, we usually simplify it to O(n²).