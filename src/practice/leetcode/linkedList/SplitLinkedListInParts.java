package practice.leetcode.linkedList;

public class SplitLinkedListInParts {
    /**
     * https://leetcode.com/problems/split-linked-list-in-parts/
     * LeetCode 725. Split Linked List in Parts
     *
     * My Solution :
     * 그냥 필요한 갯수 만큼씩 자름
     *
     * Time Complexity : O(n)
     * result : 0ms
     *
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode currentHead = head;
        int length = 0;

        while (currentHead != null) {
            length++;
            currentHead = currentHead.next;
        }
        currentHead = head;

        for (int i = 0; i < k; i++) {
            int n = (length % k) > i ? 1 : 0;
            ListNode node = currentHead;
            ListNode next = currentHead;
            for (int j = 0; j < (length / k) + n - 1; j++) {
                if (currentHead == null) break;
                next = currentHead.next;
                currentHead = currentHead.next;
            }
            if (currentHead != null) currentHead = currentHead.next;
            if (next != null) next.next = null;
            res[i] = node;
        }

        return res;
    }

    private class ListNode {
        int val;
        ListNode next;
    }

}
