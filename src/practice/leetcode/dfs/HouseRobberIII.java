package practice.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    /**
     * https://leetcode.com/problems/house-robber-iii/
     * LeetCode 337. House Robber III
     *
     * My Solution :
     * map을 사용하지 않으면 root를 방문한 케이스와 방문하지 않은 케이스들이 중복되
     * 시간 복잡도가 2^n이 된다.
     *
     * Time Complexity : O(n)
     * result : 2ms
     */

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        int ans = 0;

        if (root.left != null) {
            ans += rob(root.left.left, map) + rob(root.left.right, map);
        }

        if (root.right != null) {
            ans += rob(root.right.left, map) + rob(root.right.right, map);
        }

        ans = Math.max(ans + root.val, rob(root.left, map) + rob(root.right, map));
        map.put(root, ans);

        return ans;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
