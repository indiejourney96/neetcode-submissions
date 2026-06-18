class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>(); //why HashSet? they can remove duplicates and store unique emails;

        for (String e : emails){
            int i = 0 ;
            StringBuilder local = new StringBuilder();
            while (i < e.length() && e.charAt(i) != '@' && e.charAt(i) != '+'){
                if (e.charAt(i) != '.' ){
                    local.append(e.charAt(i));
                }
                i++;
            }
            while (i < e.length() && e.charAt(i) != '@'){
                i++;
            }
            String domain = e.substring(i + 1);
            uniqueEmail.add(local.toString() + "@" + domain);
        }
        return uniqueEmail.size();
    }
}