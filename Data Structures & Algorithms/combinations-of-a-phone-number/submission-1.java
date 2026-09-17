class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
	StringBuilder cur = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return res; //return empty
        }

        //Phone keypad mapping
        String[] phoneMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
        };

        backtrack(digits, 0, cur, res, phoneMap);
        return res;
    }

    public void backtrack(String digits, int index, StringBuilder cur, List<String> res, String[] phoneMap){
        // Base case: built a connection with same length as digits 
        if (index == digits.length()){
            res.add(cur.toString());
            return ;
        }

        // Get letters mapped to current digit
        String letters = phoneMap[digits.charAt(index) - '0'];

        // Try each letter for current digit
        for (char letter : letters.toCharArray()){
            cur.append(letter); //choose
            backtrack(digits, index + 1, cur, res, phoneMap); // explore
            cur.deleteCharAt(cur.length() - 1);

        }
    }
}

//Backtracking
//Time complexity: O(n * 4n)
//Space complexity: O(n)

// I use backtracking to build every possible letter combination one digit at a time.
// I map each digit to its letters using a phone keypad array.
// At each index, I try every letter mapped to that digit, add it to the current
// string, recurse to the next digit, then undo the choice.
// When the current string length equals digits.length(), I add it to the result.