class Solution {
    public String simplifyPath(String path) {

        List<String> directories = new ArrayList<>();

        // Split the path using slash
        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go back to the parent directory
            else if (part.equals("..")) {

                // Only remove if a directory exists
                if (!directories.isEmpty()) {
                    directories.remove(directories.size() - 1);
                }
            }

            // Valid directory or file name
            else {
                directories.add(part);
            }
        }

        // Build the simplified path
        StringBuilder result = new StringBuilder();

        for (String dir : directories) {
            result.append("/");
            result.append(dir);
        }

        // If no directories exist, return root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}

// ArrayList solution
// Complexity	Explanation
// Time     	O(n)
// Space	    O(n)

// - Splitting the path takes O(n).
// - Processing all components takes O(n) overall.
// - Building the result takes O(n).
// - The list and split array require O(n) space.