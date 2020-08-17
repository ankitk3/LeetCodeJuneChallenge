package com.challenge.july;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class July22 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resp = new ArrayList<List<Integer>>();
        if(root != null){
            List<Integer> localList = new ArrayList<Integer>();
            localList.add(root.val);
            resp.add(localList);
            add(root,false,resp, new ArrayList<Integer>());
        }

        return  resp;
    }

    private void add(TreeNode node, boolean isLeftToRight, List<List<Integer>> numberList, List<Integer> localList){
        if(node != null && (node.left != null || node.right != null)){
            if(isLeftToRight){
                if(node.left != null){
                    localList.add(node.left.val);
                }
                if(node.right != null){
                    localList.add(node.right.val);
                }
            } else{
                if(node.right != null){
                    localList.add(node.right.val);
                }
                if(node.left != null){
                    localList.add(node.left.val);
                }
            }
            numberList.add(localList);
            isLeftToRight = !isLeftToRight;
            List<Integer> newLocalList = new ArrayList<Integer>();
            add(node.left, isLeftToRight,numberList, newLocalList);
            add(node.right, isLeftToRight,numberList, newLocalList);
        }

    }
    public static void main(String[] args) {
        July22 obj = new July22();
        TreeNode input = new TreeNode();
        input.val = 3;
        input.left = new TreeNode(9);
        input.right = new TreeNode(20);

        input.left.left = new TreeNode(4);
        input.left.right = new TreeNode(5);

        input.right.left = new TreeNode(15);
        input.right.right = new TreeNode(7);
        List<List<Integer>> resp = obj.zigzagLevelOrder(input);
        for(List<Integer> inner : resp){
            for(int i : inner){
                System.out.print(i+ "\t");
            }
            System.out.println();
        }
    }
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
}
