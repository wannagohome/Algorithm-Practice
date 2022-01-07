package practice.leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
	/**
	 * https://leetcode.com/problems/linked-list-random-node/
	 * LeetCode 382. Linked List Random Node
	 *
	 * My Solution :
	 * Random 문제라서인지 런타임 시간의 편차가 꽤 크다
	 * result : 13-29ms
	 *
	 */

	List<Integer> values = new ArrayList<>();
	Random random = new Random();

	public LinkedListRandomNode(ListNode head) {
		ListNode node = head;
		do {
			values.add(node.val);
			node = node.next;
		} while (node != null);
	}

	public int getRandom() {
		int randomIndex = random.nextInt(values.size());
		return values.get(randomIndex);
	}

	private static class ListNode {
		int val;
		ListNode next;
	}

}
