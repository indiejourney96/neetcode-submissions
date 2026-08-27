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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {

            // Both p and q are smaller → LCA is on the left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both p and q are larger → LCA is on the right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // p and q are on different sides,
            // or root is p/q → current node is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}

//Iterative solution
//Time:  O(h)
//Space: O(1)    
//where h is the height of the tree.

// Use the BST property where left subtree values are smaller and right subtree values are larger than the node's value:
// if both p and q are smaller, go left; if both are larger, go right; otherwise, the current node is the LCA.
