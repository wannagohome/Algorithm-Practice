package practice.leetcode.binarytree;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
     * LeetCode 1008. Construct Binary Search Tree from Preorder Traversal
     *
     * My Solution :
     * 딱히 알고리즘이라고 할 만한게 없는 이진트리 만들기
     *
     * result : 0-2ms
     *
     */

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            construct(root, preorder[i]);
        }

        return root;
    }

    public void construct(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) node.left = new TreeNode(val);
            else construct(node.left, val);
        } else {
            if (node.right == null) node.right = new TreeNode(val);
            else construct(node.right, val);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
