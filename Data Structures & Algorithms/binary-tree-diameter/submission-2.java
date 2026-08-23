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

    public int diameterOfBinaryTree(TreeNode root) {

        // Empty tree has diameter 0
        if (root == null) {
            return 0;
        }

        // Find the height of the left subtree
        int leftHeight = getHeight(root.left);

        // Find the height of the right subtree
        int rightHeight = getHeight(root.right);

        // Diameter passing through the current node
        int diameter = leftHeight + rightHeight;

        // Find the best diameter in the left subtree
        int leftDiameter = diameterOfBinaryTree(root.left);

        // Find the best diameter in the right subtree
        int rightDiameter = diameterOfBinaryTree(root.right);

        // Return the largest diameter found
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }


    // Returns the height of a tree
    private int getHeight(TreeNode root) {

        // Empty tree has height 0
        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int leftHeight = getHeight(root.left);

        // Find height of right subtree
        int rightHeight = getHeight(root.right);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}


//Brute Force 
//Time Complexity = O(n2)
//Space complexity = 0(n)

//Brute force: Calculate the height at every node, then recursively calculate the diameter of every subtree.
//Optimization: While calculating height with DFS, calculate the diameter at the same time so each node is visited only once.