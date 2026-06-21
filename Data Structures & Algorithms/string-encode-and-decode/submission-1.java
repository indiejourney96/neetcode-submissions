class Solution {

    public String encode(List<String> strs) {
        /*
         Encode format:
         length#string

         Example:
         "neet" -> "4#neet"
         "code" -> "4#code"

         Final:
         "4#neet4#code"
        */
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s); // res = "4#neet4#code...."
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        /* Decode idea:
         Read length until '#'
         Then take substring of that length
        */        
        while (i < str.length()){
            int j = i; 
            /*
             Step 1:
             Find '#', which separates length and string
             Example:
             "4#neet"
              ^
             j stops here
            */            
            while (str.charAt(j) != '#'){
                j++;
            }

            /*
             Step 2:
             Extract length (string -> int)
             Example:
             "4" -> 4
            */            
            int length = Integer.parseInt(str.substring(i, j)); //i = 0, j = 1 → substring(0,1) = "4"
            
            /*
             Step 3:
             Move i to start of actual string
             */
            i = j + 1; // i = 2

            /*
             Step 4:
             Extract string using known length
             We DO NOT search for delimiters — we slice directly
            */            
            j = i + length; // j = 2 + 4 = 6

            res.add(str.substring(i, j)); //str.substring(2,6) - neet, res = ["neet"]

            /*
             Move pointer to next encoded block
            */
            i = j ; // i = 6
        }
        return res;
    }
}
