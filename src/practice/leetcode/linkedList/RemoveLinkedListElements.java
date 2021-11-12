package practice.leetcode.linkedList;

public class RemoveLinkedListElements {
    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     * LeetCode 203. Remove Linked List Elements
     *
     * My Solution :
     * Linked List 기초
     *
     * Time Complexity : O(n)
     * result : 1ms
     *
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    private class ListNode {
        int val;
        ListNode next;
    }
}
