package practice.leetcode.tree;

public class InvertBinaryTree {
    /**
     * https://leetcode.com/problems/invert-binary-tree/
     * LeetCode 226. Invert Binary Tree
     *
     * My Solution :
     * 그냥 재귀적으로 양쪽을 바꾸면 끝
     * 처음엔 left와 right를 담아두지 않고 실행 했다가
     * invert된 right가 left로 들어가고 다리 invert되서 right로 돌아가는 오류가 있었다.
     *
     * result : 0ms
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
