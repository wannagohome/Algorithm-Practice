package practice.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    /**
     * https://leetcode.com/problems/cousins-in-binary-tree/
     * LeetCode 993. Cousins in Binary Tree
     *
     * My Solution :
     * 그냥 bfs
     *
     * Time Complexity : O(n)
     * result : 1ms
     *
     */

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode parent = null;
        int parentDepth = -1;
        int depth = -1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                size--;

                if (node.left != null && (node.left.val == x || node.left.val == y)) {
                    if (parentDepth == -1) {
                        parentDepth = depth;
                        parent = node;
                    } else {
                        return parentDepth == depth && parent != node;
                    }
                }
                if (node.right != null && (node.right.val == x || node.right.val == y)) {
                    if (parentDepth == -1) {
                        parentDepth = depth;
                        parent = node;
                    } else {
                        return parentDepth == depth && parent != node;
                    }
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
