class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        // Characters we need
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        // Current window
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int have = 0;
        int need = target.size();

        String ans = "";

        // Expand window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // One required character is now satisfied
            if (target.containsKey(c)
                    && window.get(c).equals(target.get(c))) {
                have++;
            }

            // Current window contains all required characters
            while (have == need) {

                String current = s.substring(left, right + 1);

                if (ans.equals("") || current.length() < ans.length()) {
                    ans = current;
                }

                // Remove left character
                char remove = s.charAt(left);
                window.put(remove, window.get(remove) - 1);

                if (target.containsKey(remove)
                        && window.get(remove) < target.get(remove)) {
                    have--;
                }

                left++;
            }
        }

        return ans;
    }
}


// Instead of rebuilding the window,

// keep one window alive.

// Expand until valid.

// Then shrink while still valid.

// Repeat.