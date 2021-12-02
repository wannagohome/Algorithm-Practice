package practice.leetcode.linkedList;

public class OddEvenLinkedList {
	/**
	 * https://leetcode.com/problems/odd-even-linked-list/
	 * LeetCode 328. Odd Even Linked List
	 *
	 * My Solution :
	 * Linked List 기초
	 *
	 * Time Complexity : O(n)
	 * result :01ms
	 *
	 */

	public ListNode oddEvenList(ListNode head) {
		int index = 1;
		ListNode currentNode = head;
		ListNode lastNode = null;
		ListNode lastOdd = head;

		while (currentNode != null) {
			if (index % 2 == 1 && index > 2) {
				lastNode.next = currentNode.next;
				currentNode.next = lastOdd.next;
				lastOdd.next = currentNode;
				lastOdd = currentNode;
				currentNode = lastNode;
			}
			index++;
			lastNode = currentNode;
			currentNode = currentNode.next;
		}

		return head;
	}

	private class ListNode {
		int val;
		ListNode next;
	}
}
