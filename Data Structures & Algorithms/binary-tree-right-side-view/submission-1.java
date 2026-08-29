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
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    if (root == null) return res;

    queue.offer(root);

    while (!queue.isEmpty()){
        TreeNode rightSide = null;
        int queueSize = queue.size();
        for (int i = 0; i < queueSize ;i++){
            TreeNode node = queue.poll();
            // The last node processed at this level is the rightmost node
            rightSide = node;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        res.add(rightSide.val);
        }
    return res;
    }
}


//BFS
//Time complexity: O(n)
//Space complexity: O(n)

//I'll use BFS to process the tree level by level. For each level, I record the last node that I process. Since nodes are processed from left to right, the last node is the rightmost node visible from that level. I then add that node to the result.