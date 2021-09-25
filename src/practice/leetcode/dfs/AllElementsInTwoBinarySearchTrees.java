package practice.leetcode.dfs;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {
    /**
     * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
     * LeetCode 1305. All Elements in Two Binary Search Trees
     *
     * My Solution :
     * 첫 번째 해답은 모든 방문 경로를 List 형태로 return
     * List 를 return 하기 위해 매번 new ArrayList 호출
     *
     * 두 번째 시도에서 객체생성을 모두 빼고 전역변수 하나로 관리
     *
     * Time Complexity : O(n)
     * result : 56-151ms -> 28-50ms
     *
     * Other Solution :
     * 런타임 시간이 하위 20%가량으로 나온것을 보면
     * 분명 더 빠른 해답이 있을 텐데 아쉽게도 찾지 못했다.
     */

    /**
     * 1차 시도
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        ans.addAll(getElements(root1));
        ans.addAll(getElements(root2));
        ans.sort(Comparator.naturalOrder());
        return ans;
    }

    public List<Integer> getElements(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> grouped = new ArrayList<>(List.of(root.val));
        if (root.left != null) grouped.addAll(getElements(root.left));
        if (root.right != null) grouped.addAll(getElements(root.right));
        if (root.left == null && root.right == null) return new ArrayList<>(List.of(root.val));
        else return grouped;
    }

    /**
     * 2차 시도
     */
    List<Integer> ans = new ArrayList<>();

    public List<Integer> improve(TreeNode root1, TreeNode root2) {
        getElementsFaster(root1);
        getElementsFaster(root2);
        Collections.sort(ans);
        return ans;
    }

    public void getElementsFaster(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        getElementsFaster(root.left);
        getElementsFaster(root.right);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
