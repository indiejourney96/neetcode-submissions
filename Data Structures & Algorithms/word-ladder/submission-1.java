class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0 ; i < size ; i++){
                String word = queue.poll();

                if (word.equals(endWord)){
                    return steps;
                }

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++){
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++){
                        if (c == original){
                            continue;
                        }

                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (wordList.contains(nextWord) && !visited.contains(nextWord)){
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}
