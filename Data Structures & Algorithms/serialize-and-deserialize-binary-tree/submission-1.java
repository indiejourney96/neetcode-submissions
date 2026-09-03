/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                res.append("N,");
            } else {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null; // If the serialized tree was empty, return null.

        TreeNode root = new TreeNode(Integer.parseInt(vals[0])); // First value is always the root.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Start at index 1 because index 0 was used for the root.
        int index = 1;  

        while (!queue.isEmpty()){            
            TreeNode node = queue.poll();
            // Left child
            if (!vals[index].equals("N")){ // "N" means there is no left child.
                // Create the left child.
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.left);
            }
            index++; 
            
            // Right child
            if (!vals[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.right);
            }
            index++; 
        }
        return root;
    }
}

//BFS
//Serialize:
//Time:  O(N) — every node visited exactly once
//Space: O(N) — result list stores every node + null markers

//Deserialize:
//Time:  O(N) — every value in the array processed exactly once
//Space: O(N) — recursion call stack O(H), worst case O(N) skewed tree

//For serialize, I do a level-order traversal and record every node's value. For null nodes I record 'N' — this is essential so I know where subtrees end during reconstruction. I join everything with commas into one string. For deserialize, I split the string and use a shared index counter — same trick as Build Tree — that auto-advances as I consume each value. I rebuild the tree in the same level-order sequence: create the root, then recurse left, then recurse right.


//    1            
//   / \           
//  2   3            
             
//1,2,3,N,N,N,N       