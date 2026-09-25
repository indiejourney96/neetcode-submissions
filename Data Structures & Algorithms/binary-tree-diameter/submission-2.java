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
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int diameter = left + right;

        int leftDiameter = diameterOfBinaryTree(root.left);

        int rightDiameter = diameterOfBinaryTree(root.right);


        return Math.max(diameter,Math.max(leftDiameter,rightDiameter));
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0; 
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int count = 1 + Math.max(left, right);

        return count; 
    }
}
