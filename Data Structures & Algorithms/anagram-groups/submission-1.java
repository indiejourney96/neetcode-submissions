class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        //Key, Value : "[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]"->["eat","tea","ate"]

        for (String s : strs){
            int[] count = new int[26];
            char[] charArray = s.toCharArray(); //['e','a','t']
            for (char c : charArray){
                count[c - 'a']++;
            }
            String sortedStr = Arrays.toString(count); // "[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]"
            ans.putIfAbsent(sortedStr, new ArrayList<>()); // "[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]" : [] 
            ans.get(sortedStr).add(s); //"[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]" : ["str"] 
        }
        List<List<String>> res = new ArrayList<>(ans.values()); 
        return res;
    }
}