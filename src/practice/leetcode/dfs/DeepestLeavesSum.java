package practice.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepestLeavesSum {
    /**
     * https://leetcode.com/problems/deepest-leaves-sum/
     * LeetCdoe 1302. Deepest Leaves Sum
     *
     * My Solution : 큐(bfs)를 사용하여 한 depth씩 값들을 합함
     * Time Complexity : O(n)
     * result : 5ms 22%
     *
     * Better Solution : 처음 생각했던 대로 깊이에 대한 정보를 활용
     * 다만 나는 깊이의 대한 정보를 return 하기 위해 map을 사용하려 했으나
     * 간단하게 최대 깊이를 전역변수로만 빼두면 끝.
     * 아주 단순한 생각을 못했다.
     * 시간 복잡도는 같지만 자료구조에 넣고 빼는 과정 없이 단순한 사칙연산만으로
     * 가능해지기 때문에 더욱 빠르다
     *
     * Time Complexity : O(n)
     * result : 0ms 100%
     */

    public int mySolution(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum;
        Stack<TreeNode> stack = new Stack<>();
        do {
            sum = 0;
            for (TreeNode s : stack) {
                queue.offer(s);
            }
            stack.removeAllElements();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        } while (!stack.isEmpty());
        return sum;
    }

    private int maxLevel = 0;
    private int sum = 0;

    public int betterSolution(TreeNode root) {
        if(root == null) return 0;
        calculateSumAtLevel(root,0);
        return sum;

    }

    private void calculateSumAtLevel(TreeNode root,int level){

        if(root == null) return;
        if(level > maxLevel){
            sum = 0;
            maxLevel = level;
        }
        if(level == maxLevel){
            sum = sum + root.val;
        }
        calculateSumAtLevel(root.left,level+1);
        calculateSumAtLevel(root.right,level+1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
