class TimeMap {

    // Pair stores one (value, timestamp)
    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // Store:
    // key -> list of (timestamp, value)
    //
    // Example:
    // "foo" ->
    // [(1,"bar"), (4,"bar2"), (7,"bar3")]
    Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        // First time seeing this key
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }

        // Timestamps are added in increasing order, so simply append to the end.
        store.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        // Key doesn't exist
        if (!store.containsKey(key)) {
            return "";
        }

        List<Pair> list = store.get(key);

        int left = 0;
        int right = list.size() - 1;

        String answer = "";

        // Binary search for the latest timestamp <= target
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                // Valid answer found.
                // Save it and try to find an even later timestamp.
                answer = list.get(mid).value;
                left = mid + 1;
            } else {

                // Timestamp is too large. Search the left half.
                right = mid - 1;
            }
        }

        return answer;
    }
}