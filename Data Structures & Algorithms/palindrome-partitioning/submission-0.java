class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(0, s, part, res);
        return res;
    }

    public void backtrack(int i, String s, List<String> part, List<List<String>> res){
        // Base case: reached end of string, add current partition
        if (i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++){
            // Only proceed if substring s[i...j] is a palindrome
            if (isPali(s, i, j)){
                part.add(s.substring(i, j + 1)); //choose
                backtrack(j + 1, s, part, res); //explore
                part.remove(part.size() - 1); //undo
            }
        }
    }

    // Check if substring s[l...r] is a palindrome
    public boolean isPali(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

//Backtrack 
//Time complexity: O(n * 2^n)
//Space complexity: O(n) extra space, O(n * 2^n) space for output list

//I use backtracking to explore all possible partitions. Starting at each index, I try every substring from that position. If it's a palindrome, I add it to the current partition, recurse to the next position, then backtrack by removing it. When I reach the end of the string, I save the partition to the result.
