import java.util.Stack;

class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseList(ListNode head) {
		ListNode listNode = new ListNode();
		ListNode cur = head;
		ListNode cur1 = listNode;
		Stack<ListNode> stack = new Stack<>();
		while(cur
				!= null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (!stack.isEmpty()) {
			cur1.next = new ListNode(stack.pop().val);
			cur1 = cur1.next;
		}
		return listNode.next;
	}
}
