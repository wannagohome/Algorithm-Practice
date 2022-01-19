package practice.leetcode.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListCycleII {

	/**
	 * https://leetcode.com/problems/linked-list-cycle-ii/
	 * LeetCode 142. Linked List Cycle II
	 *
	 * My Solution :
	 * 순차적으로 탐색
	 * result : 16ms
	 *
	 * Faster Solution :
	 * 투 포인터로 탐색
	 * result : 0-1ms
	 */

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode node = head;
		Map<Integer, List<ListNode>> map = new HashMap<>();
		map.computeIfAbsent(node.val, x -> new ArrayList<>()).add(node);

		while (node.next != null) {
			node = node.next;
			if (map.containsKey(node.val) && map.get(node.val).contains(node))
				return node;
			map.computeIfAbsent(node.val, x -> new ArrayList<>()).add(node);
		}

		return null;
	}

	public ListNode faster(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow){
				ListNode slow2 = head;
				while (slow2 != slow){
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

	private static class ListNode {
		int val;
		ListNode next;
	}
}
