class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        //Key, Value : "aet"->["eat","tea","ate"]
        for (String s : strs){
            char[] charArray = s.toCharArray(); //['e','a','t']
            Arrays.sort(charArray); //['a','e','t']
            String sortedStr = new String (charArray);
            ans.putIfAbsent(sortedStr, new ArrayList<>()); // "aet" : [] 
            ans.get(sortedStr).add(s);//   "aet" : ["eat"]
        }
        List<List<String>> res = new ArrayList<>(ans.values()); 
        return res;
    }
}
