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
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        // Join all values with comma separator → "1,2,N,N,3,N,N"
        return String.join(",", res);
    }

    public void dfsSerialize(TreeNode node, List<String> res){
        if (node == null){
            res.add("N"); // Null node — record as "N" so we know where subtrees end
            return ;
        }
        // Preorder: record current node first, then recurse left, then right
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        // int[] instead of int — so all recursive calls share the same index
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }

    public TreeNode dfsDeserialize(String[] vals, int[] i){
        // If current value is "N", this is a null node — advance index and return null
        if (vals[i[0]].equals("N")){
            i[0]++; 
            return null;
        }
        // Create the node from current value, then advance the index
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        // Preorder: rebuild left subtree first, then right subtree
        // i auto-advances as each node is consumed — same trick as buildTree        
        node.left = dfsDeserialize(vals, i);
        node.right = dfsDeserialize(vals, i);
        return node; 
    }
}

//DFS
//Serialize:
//Time:  O(N) — every node visited exactly once
//Space: O(N) — result list stores every node + null markers

//Deserialize:
//Time:  O(N) — every value in the array processed exactly once
//Space: O(N) — recursion call stack O(H), worst case O(N) skewed tree

//For serialize, I do a preorder DFS and record every node's value. For null nodes I record 'N' — this is essential so I know where subtrees end during reconstruction. I join everything with commas into one string. For deserialize, I split the string and use a shared index counter — same trick as Build Tree — that auto-advances as I consume each value. I rebuild the tree in the same preorder sequence: create the current node, then recurse left, then recurse right.