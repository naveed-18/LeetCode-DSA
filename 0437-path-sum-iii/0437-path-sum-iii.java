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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, 1);

        return getPathSum (root, 0L, targetSum, hm);
    }

    public int getPathSum (TreeNode root, long prefixSum, 
        int targetSum, Map<Long, Integer> hm) {

        if (root == null) return 0;

        prefixSum += root.val;
        int count = hm.getOrDefault(prefixSum - targetSum, 0);

        hm.put(prefixSum, hm.getOrDefault (prefixSum, 0) + 1);

        count += getPathSum (root.left, prefixSum, targetSum, hm);
        count += getPathSum (root.right, prefixSum, targetSum, hm);

        hm.put(prefixSum, hm.get(prefixSum) - 1);

        return count;
    }
}