package practice.leetcode.dfs;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {
    /**
     * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
     * LeetCode 430. Flatten a Multilevel Doubly Linked List
     *
     * My Solution :
     * 단순한 dfs
     * Time Complexity : O(n)
     * result : 0ms
     */

    Stack<Node> stack = new Stack<>();

    public Node flatten(Node head) {
        if (head == null) return null;

        if (head.child == null) {
            if (head.next != null) {
                Node node = flatten(head.next);
                head.next = node;
                node.prev = head;
            } else {
                if (!stack.isEmpty()) {
                    Node node = flatten(stack.pop());
                    head.next = node;
                    node.prev = head;
                }
            }
        } else {
            if (head.next != null) {
                head.next.prev = null;
                stack.push(head.next);
            }
            Node node = flatten(head.child);
            head.next = node;
            node.prev = head;
            head.child = null;
        }
        return head;
    }

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
