package practice.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteLeavesWithAGivenValue {
    /**
     * https://leetcode.com/problems/delete-leaves-with-a-given-value/
     * LeetCode 1325. Delete Leaves With a Given Value
     *
     * My Solution :
     * root는 leaf가 잘려나간 left와 right의 합
     * left와 right를 가지치기 하고 나니 내가 잘려나갈 놈이면 나도 떨어짐
     * 간단
     *
     * Time Complexity : O(n)
     * result : 0ms
     *
     */

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target)
            root = null;
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
