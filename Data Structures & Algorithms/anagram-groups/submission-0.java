class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        //Key, Value : "aet"->["eat","tea","ate"]

        for (String s : strs){
            char[] charArray = s.toCharArray(); //['e','a','t']
            Arrays.sort(charArray); //['a','e','t']
            String sortedStr = new String(charArray);
            res.putIfAbsent(sortedStr, new ArrayList<>()); // "aet" : [] 
            res.get(sortedStr).add(s); //   "aet" : ["eat"]
        }
        
        List<List<String>> ans = new ArrayList<>(res.values());
        return ans;
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(n)