package practice.leetcode.dfs;

public class RangeSumOfBST {
    /**
     * https://leetcode.com/problems/range-sum-of-bst/
     * LeetCdoe 938. Range Sum of BST
     *
     * My Solution : BFS로 간단하게 풀이
     * 스택을 사용하거나 방문을 체크할 수 있도록 한다면 DFS로 풀수도 있겠으나 굳이?
     * result : 1ms
     */

    private static int solution(TreeNode root, int low, int high) {
        int ans = 0;
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        return ans
                + (root.left != null ? solution(root.left, low, high) : 0)
                + (root.right != null ? solution(root.right, low, high) : 0);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
