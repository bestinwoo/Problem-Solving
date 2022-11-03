//LeetCode Linked List Cycle
class Solution {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;

		ListNode first = head;
		ListNode second = first.next;
		while (second != null && second.next != null) {
			if(first == second) {
				return true;
			}
			first = first.next;
			second = second.next.next;
		}
		return false;
	}
}
