class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;

    // Find a node quickly using its key
    private HashMap<Integer, Node> cache;

    // Dummy nodes
    // left = least recently used side
    // right = most recently used side
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Create dummy left and right nodes
        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node at the RIGHT side
    // This makes it the most recently used
    private void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {

        // Key doesn't exist
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Move it to the most recently used position
        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            // Update its value
            node.val = value;

            // Move it to the most recently used position
            remove(node);
            insert(node);

        } else {

            // Create a new node
            Node node = new Node(key, value);

            // Add it to the HashMap
            cache.put(key, node);

            // Add it to the most recently used position
            insert(node);
        }

        // Cache is too large
        if (cache.size() > capacity) {

            // The node immediately after left is
            // the least recently used node
            Node lru = left.next;

            // Remove it from the linked list
            remove(lru);

            // Remove it from the HashMap
            cache.remove(lru.key);
        }
    }
}