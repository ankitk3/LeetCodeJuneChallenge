package com.challenge.june;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 *
 * Invert a binary tree.
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class June1Challenge {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            if(root.left != null && root.right != null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            } else if(root.left != null){
                root.right = root.left;
                root.left = null;
            } else if(root.right != null){
                root.left = root.right;
                root.right = null;
            }
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    public static void main(String[] args) {
        June1Challenge obj = new June1Challenge();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        left = new TreeNode(1);
        right = new TreeNode(3);
        root.left.left = left;
        root.left.right = right;

        left = new TreeNode(6);
        right = new TreeNode(9);
        root.right.left = left;
        root.right.right = right;
        TreeNode resp = obj.invertTree(root);
        System.out.println(resp);
    }
}
