class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>(); //why HashSet? they can remove duplicates and store unique emails;

        for (String e : emails){
            String[] parts = e.split("@");
            String local = parts[0];
            String domain = parts[1];

            local = local.split("\\+")[0];
            local = local.replace(".", "");
            uniqueEmail.add(local + "@" + domain);
        }
        return uniqueEmail.size();
    }
}