class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s); //res = "4#neet4#code"
        }
        return res.toString();
        }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0; 

        while (i < str.length()){
            int j = i; 
            while (str.charAt(j) != '#'){ //"4#neet" -> stop at 4
                j++; //j = 1
            }
            int length = Integer.parseInt(str.substring(i,j)); //i = 0, j = 1 → substring(0,1) = "4"
            i = j + 1; // Move i to start of actual string, i =1+1 =2
            j = i + length; // j = 2 + 4 = 6
            res.add(str.substring(i,j)); //str.substring(2,6)-neet, res = ["neet"]
            i = j; // i = 6
        }
        return res;
    }
}

//Time Complexity: O(m + n) for each function 
//Space Complexity: O(m + n) for each function 

// The main challenge is that each string may contain any ASCII character, 
// so I need an encoding that's unambiguous. 
// I'll prefix every string with its length followed by a separator. 
// For example, Hello becomes 5#Hello. 
// During decoding, I read the number until #, convert it to an integer, 
// then read exactly that many characters to recover the original string. 
// This avoids delimiter collisions and runs in linear time