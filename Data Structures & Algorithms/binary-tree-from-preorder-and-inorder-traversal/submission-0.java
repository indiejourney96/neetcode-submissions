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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        // Preorder rule: first element is always the root of this subtree
        TreeNode root = new TreeNode(preorder[0]);
        
        // Find where the root sits in inorder
        // Everything left of mid = left subtree
        // Everything right of mid = right subtree
        int mid = -1;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }

        // Left subtree:
        // - inorder: everything before mid
        // - preorder: skip index 0 (root), take next 'mid' elements
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        // Right subtree:
        // - inorder: everything after mid
        // - preorder: everything after the left subtree elements
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}

//Time:  O(N²) — for each of N nodes, you scan inorder to find mid (O(N))
//               and copyOfRange creates new arrays (O(N))
//Space: O(N²) — new arrays created at every recursive call

//Preorder tells me the root is always the first element. I find that root in the inorder array — everything to its left is the left subtree, everything to its right is the right subtree. I split both arrays accordingly and recurse. Each recursive call builds one node and connects its left and right subtrees."
