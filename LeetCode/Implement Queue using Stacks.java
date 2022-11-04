import java.util.Stack;
//LeetCode Implement Queue using Stacks
class MyQueue {
	private final Stack<Integer> stack1;
	private final Stack<Integer> stack2;
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		int size = stack1.size();
		for(int i = 0; i < size; i++) {
			stack2.push(stack1.pop());
		}

		Integer pop = stack2.pop();
		size = stack2.size();
		for(int i = 0; i < size; i++) {
			stack1.push(stack2.pop());
		}
		return pop;
	}

	public int peek() {
		return stack1.firstElement();
	}

	public boolean empty() {
		return stack1.empty();
	}
}
