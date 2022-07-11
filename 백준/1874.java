import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n, cur = 1;
		Stack<Integer> s = new Stack<>();
		Queue<Integer> rq = new LinkedList<>();
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			rq.add(Integer.parseInt(br.readLine()));
		}

		while(!rq.isEmpty()) {
			if(cur < rq.peek()) {
				s.push(cur++);
				sb.append("+\n");
			} else if(rq.peek().equals(cur)) {
				cur++;
				rq.poll();
				sb.append("+\n-\n");
			} else {
				if(s.peek().equals(rq.peek())) {
					s.pop();
					rq.poll();
					sb.append("-\n");
				} else {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println(sb);
	}

}
