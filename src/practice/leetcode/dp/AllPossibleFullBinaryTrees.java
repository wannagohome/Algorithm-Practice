package practice.leetcode.dp;

import java.util.*;

public class AllPossibleFullBinaryTrees {
    /**
     * https://leetcode.com/problems/all-possible-full-binary-trees/
     * LeetCode 894. All Possible Full Binary Trees
     *
     * My Solution : dp
     * 5개 짜리 tree는 좌우 3개 짜리와 1개 짜리의 합
     *
     * result : 1s
     */

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
