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
