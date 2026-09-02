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

class Solution {
    int pre_idx = 0; // tracks which preorder element to use next
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build map once: value → index in inorder for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r){
        if (l > r) return null; // Base case: no elements in this subtree

        // Preorder rule: next element is always the root of this subtree
        // pre_idx++ uses current value then advances for the next call
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);

        // Find root in inorder — left of mid is left subtree, right is right subtree
        int mid = indices.get(root_val);


        // IMPORTANT: left subtree MUST be built before right
        // because pre_idx advances automatically with each node created        
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        
        return root;
    }
}


//Time:  O(N) — each node visited once, O(1) HashMap lookup
//Space: O(N) — HashMap + call stack O(H)

//Preorder tells me the next root is always the next element in the array. I use a counter that auto-advances every time I create a node. I find that root in the inorder array using a HashMap in O(1) — everything left of it is the left subtree, everything right is the right subtree. I recurse on both sides and the counter handles the preorder indexing automatically