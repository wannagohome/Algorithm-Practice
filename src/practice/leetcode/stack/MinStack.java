package practice.leetcode.stack;

public class MinStack {
    /**
     * https://leetcode.com/problems/min-stack/
     * LeetCode 155. Min Stack
     *
     * Solution :
     * 각 스택마다 최소값을 함께 저장해서 상수의 시간 복잡도를 만든다
     * inner class 하나로 쉽게 구현하는 발상이 놀랍다
     *
     * Time Complexity : O(1)
     * result : 4-9ms
     */

    private Node head;

    public void push(int x) {
        if (head == null) head = new Node(x, x, null);
        else head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
