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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(root);

        while (!bfsQueue.isEmpty()) {
            int n = bfsQueue.size();

            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode currNode = bfsQueue.poll();
                sum += currNode.val;

                if (currNode.left != null) bfsQueue.offer(currNode.left);
                if (currNode.right != null) bfsQueue.offer(currNode.right);
            }

            result.add(sum / n);
        }

        return result;
    }
}