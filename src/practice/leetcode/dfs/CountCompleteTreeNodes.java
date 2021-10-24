package practice.leetcode.dfs;

public class CountCompleteTreeNodes {
    /**
     * https://leetcode.com/problems/count-complete-tree-nodes/
     * LeetCode 222. Count Complete Tree Nodes
     *
     * My Solution :
     * 완전한 이진 트리의 특성을 활용한 binary search
     *
     * Time Complexity : O(log n)
     * result : 3-5ms
     */

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int depth = countDepth(root);
        int min = (int) Math.pow(2, depth);
        int max = (int) Math.pow(2, depth + 1) - 1;

        if (depth == 0) return 1;
        if (checkExistence(root, Integer.toBinaryString(max).substring(1))) return max;
        while (max - min != 1) {
            int num = (max + min) / 2;
            if (checkExistence(root, Integer.toBinaryString(num).substring(1))) min = num;
            else max = num;
        }

        return min;
    }

    public int countDepth(TreeNode node) {
        if (node.left == null) return 0;
        return countDepth(node.left) + 1;
    }

    public boolean checkExistence(TreeNode node, String binary) {
        if (binary.length() == 1) {
            if (binary.charAt(0) == '0') return node.left != null;
            else return node.right != null;
        } else {
            if (binary.charAt(0) == '0') return checkExistence(node.left, binary.substring(1));
            else return checkExistence(node.right, binary.substring(1));
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
