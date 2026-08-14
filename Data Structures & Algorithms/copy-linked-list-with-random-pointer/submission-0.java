/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        
        //Step 1: Create all new nodes
        Node cur = head;

        while (cur != null){
            Node copy = new Node(cur.val); //Create a new node with same value
            oldToCopy.put(cur, copy); //Remember which copy belongs to this original node
            cur = cur.next;
        }

        //Step 2: Connect the pointers
        cur = head;

        while (cur != null){
            Node copy = oldToCopy.get(cur); //Get copy of current original node

            if (cur.next != null){ //Connect copid 'next' pointer
                copy.next = oldToCopy.get(cur.next);
            }

            if (cur.random != null){ //Connect the copied 'random' pointer
                copy.random = oldToCopy.get(cur.random);
            }

            cur = cur.next;
        }
        return oldToCopy.get(head);
    }
}


//HashMap Two Passes 
//Time Complexity: O(n)
//Space Complexity: O(n)

//I'll use a HashMap to map each original node to its copied //node. In the first pass, I create a copy of every node and //store the mapping. In the second pass, I use the map to //connect each copied node's next and random pointers to the //corresponding copied node.