import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			char[] function = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String[] num = br.readLine().split(",");
			if(n > 0) {
				num[0] = num[0].replace("[", "");
				num[n - 1] = num[n - 1].replace("]", "");
			}
			ac(function, n, num);
		}
	}

	private static void ac(char[] function, int n, String[] num) {
		boolean flag = false;
		boolean error = false;
		Deque<String> deque = new ArrayDeque<>();
		if(n > 0) {
			deque = new ArrayDeque<>(List.of(num));
		}

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (char c : function) {
			if (c == 'R') {
				flag = !flag;
			} else if (c == 'D') {
				if (deque.isEmpty()) {
					error = true;
					break;
				}
				if (flag) {
					deque.removeLast();
				} else {
					deque.removeFirst();
				}
			}
		}
		while (!deque.isEmpty()) {
			sb.append(flag ? deque.pollLast() : deque.pollFirst());
			if (!deque.isEmpty()) {
				sb.append(",");
			}
		}
		sb.append(']');
		
		System.out.println(error ? "error" : sb.toString());
	}
}
