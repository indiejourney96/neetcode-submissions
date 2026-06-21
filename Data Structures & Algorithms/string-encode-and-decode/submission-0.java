class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        /*
         STEP 1: Store lengths of each string
         Example:
         ["neet","code","love","you"]
         sizes = [4,4,4,3]
        */
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs){
            sizes.add(str.length()); //sizes = [4,4,4,3]
        }
        /*
         STEP 2: Append all sizes first
         Format: "4,4,4,3,"
         This acts as metadata (blueprint for decoding)
        */
        for (int size : sizes){
            result.append(size).append(','); //result = "4,4,4,3"
        }
        /*
         STEP 3: Separator between metadata and actual strings
         '#' marks end of size section
        */
        result.append('#'); //result = [4,4,4,3,#]
        /*
         STEP 4: Append all strings back-to-back
         Example:
         "neetcodeloveyou"
        */
        for (String str : strs){
            result.append(str); //result = "4,4,4,3,#neetcodeloveyou" (Stringbuilder)
        }
        
    return result.toString();
    }

    public List<String> decode(String str) {
        // Edge case: empty encoded string
        if (str.length() == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i = 0 ; 

        /*
         STEP 1: Read size metadata until '#'
         Format:
         "4,4,4,3,#"
         
         We extract each number between commas
        */
        while (str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            // Build current number (could be multiple digits in general)
            while (str.charAt(i) != ','){
                cur.append(str.charAt(i)); // cur = "4" → "4" → "4" → "3"
                i++;
            }
            // Convert extracted number string → integer size
            sizes.add(Integer.parseInt(cur.toString())); //sizes = [4,4,4,3] when i = 3
            // move past comma
            i++;
        }
        // move past '#'
        i++;

         /*
         STEP 2: Use sizes as a roadmap to extract strings
         IMPORTANT IDEA:
         We do NOT search for boundaries.
         We already KNOW lengths in advance.
        */       
        for (int size : sizes){
            // Take substring of exact length
            result.add(str.substring(i, i + size)); //["neet","code","love","you"]
            // move pointer forward
            i = i + size;
        }
        return result;
    }
}
