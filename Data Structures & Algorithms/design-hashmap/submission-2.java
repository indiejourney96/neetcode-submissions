class ListNode {
    int key;
    int value;
    ListNode next;

    // Constructor for creating a new node
    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    // Constructor for creating a dummy (sentinel) node
    public ListNode() {
        this(-1, -1, null);
    }
}

class MyHashMap {

    // Array containing linked list buckets
    private ListNode[] map;

    public MyHashMap() {
        // Create 1000 buckets
        map = new ListNode[1000];

        // Initialise every bucket with a dummy node
        for (int i = 0; i < map.length; i++) {
            map[i] = new ListNode();
        }
    }

    // Convert a key into an array index
    private int hash(int key) {
        return key % map.length;
    }

    public void put(int key, int value) {

        // Find the correct bucket using the hash function
        ListNode cur = map[hash(key)];

        // Traverse the linked list to check whether the key exists
        while (cur.next != null) {

            // If key already exists, update its value
            if (cur.next.key == key) {
                cur.next.value = value;
                return;
            }

            cur = cur.next;
        }

        // Key does not exist, so insert a new node at the end
        cur.next = new ListNode(key, value, null);
    }

    public int get(int key) {

        // Start from the first actual node, skipping the dummy node
        ListNode cur = map[hash(key)].next;

        // Search through the linked list
        while (cur != null) {

            // Return the value if the key is found
            if (cur.key == key) {
                return cur.value;
            }

            cur = cur.next;
        }

        // Key does not exist
        return -1;
    }

    public void remove(int key) {

        // Start from the dummy node
        ListNode cur = map[hash(key)];

        // Check the next node because we need its previous node to remove it
        while (cur.next != null) {

            // If the next node contains the key, remove it
            if (cur.next.key == key) {

                // Skip the node we want to remove
                cur.next = cur.next.next;
                return;
            }

            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


// LinkedList 
// Time Complexity :O(n/k)
// Space Complexity: O(k + m)

// n = number of keys 
// k = size of map 
// m = number of unique keys