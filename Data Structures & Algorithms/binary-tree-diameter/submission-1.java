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
    
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;    
    }

    //Returns the height of the tree and updates the max diameter
    private int getHeight(TreeNode root){
        //Empty tree has height 0
        if (root == null){
            return 0;
        }

        //Find height of left subtree
        int leftHeight = getHeight(root.left);

        //Find height of right subtree
        int rightHeight = getHeight(root.right);

        //Diameter passing through this node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        //Return height of this node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

//Optimal DFS
//Time complexity: O(n)
//Space complexity: O(h)

//Where n is the number of nodes in the tree and hh is the height of the tree.

//For each node, the diameter passing through that node is the height of its left subtree plus the height of its right subtree. My first solution calculates the height separately for every node, which can cause repeated work. To optimize it, I calculate the height using DFS and update the maximum diameter during the same traversal. This lets me visit every node once, giving O(n) time.