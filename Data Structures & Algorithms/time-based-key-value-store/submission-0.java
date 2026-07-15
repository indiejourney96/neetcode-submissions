class TimeMap {

    Map<String, Map<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // First time seeing this key
        if (!store.containsKey(key)) {
            store.put(key, new HashMap<>());
        }
        // Save value at this timestamp
        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        // Key doesn't exist
        if (!store.containsKey(key)) {
            return "";
        }
        // Keep track of the latest timestamp
        // that is <= requested timestamp
        int latestTime = -1;

        // Brute force:
        // Check every timestamp stored for this key
        for (int time : store.get(key).keySet()) {
            if (time <= timestamp && time > latestTime) {  // Valid timestamp and newer than previous best
                latestTime = time;
            }
        }
        // No valid timestamp found
        if (latestTime == -1) {
            return "";
        }
        // Return the value stored at the latest valid timestamp
        return store.get(key).get(latestTime);
    }
}


    // Store:
    // key -> (timestamp -> value)
    //
    // Example:
    // "foo" ->
    // {
    //     1 -> "bar",
    //     4 -> "bar2"
    // }

//For each key, I store a map of timestamp → value. 
//When retrieving a value, I scan all timestamps for that key and 
//keep track of the largest timestamp that is less than or equal to the requested timestamp. 
//Finally, I return the value associated with that timestamp.