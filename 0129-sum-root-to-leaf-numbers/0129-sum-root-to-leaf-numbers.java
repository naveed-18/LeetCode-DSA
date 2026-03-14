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
    public int sumNumbers(TreeNode root) {
        return sumRootToLeafNum(root, 0);
    }

    public int sumRootToLeafNum (TreeNode root, int value) {
        if (root == null) return 0;
        int size = findSize(root.val);

        value = value * (int)Math.pow(10, size) + root.val;
        if (root.left == null && root.right == null) return value;

        int leftSum = sumRootToLeafNum (root.left, value);
        int rightSum = sumRootToLeafNum (root.right, value);

        return leftSum + rightSum;
    }

    public int findSize (int num) {
        if (num == 0) return 1;
        int size = 0;
        while (num > 0) {
            size++;
            num /= 10;
        }
        return size;
    }
}