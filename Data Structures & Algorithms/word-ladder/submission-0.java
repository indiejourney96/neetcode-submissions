class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        // The end word must exist in the word list
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Start BFS from beginWord
        queue.offer(beginWord);
        visited.add(beginWord);

        // Count words in the transformation sequence
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all words at the current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Reached the target word
                if (word.equals(endWord)) {
                    return steps;
                }

                // Try changing each character to a-z
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;
                        String nextWord = new String(chars);

                        // Only visit words in the list that are new
                        if (wordList.contains(nextWord)
                                && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }

                    // Restore the original character
                    chars[j] = original;
                }
            }

            // Move to the next transformation level
            steps++;
        }

        // No valid transformation sequence exists
        return 0;
    }
}

// BFS

// Time complexity: \(O(N^2 x L x 26)\), commonly simplified to \(O(N^2L)\) for this implementation, where N is the number of words and L is the word length. This accounts for checking membership in the list with wordList.contains(), which takes (O(N)).

// Space complexity: \(O(NL)) for storing the queue and visited words, plus the word list provided as input. If you mean the commonly requested (O(N^2L)) time and space, that is not the complexity of this BFS implementation: its auxiliary space is (O(NL)).

// I use BFS because we need the shortest transformation sequence. I start with beginWord in a queue and count the number of words at each level. For each word, I change each character to every letter from a to z. If the resulting word exists in the word list and has not been visited, I add it to the queue. When I reach endWord, I return the number of words in the sequence. If BFS finishes without finding it, I return zero
