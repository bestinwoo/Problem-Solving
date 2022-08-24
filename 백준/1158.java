import java.io.*;
import java.util.*;
//BOJ 1158 요세푸스 문제
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		int cnt = 1;
		while(!q.isEmpty()) {
			Integer poll = q.poll();
			if(cnt >= k) {
				answer.add(poll);
				cnt = 0;
			} else {
				q.add(poll);
			}
			cnt++;
		}

		System.out.print("<");
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i));
			if(i < answer.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}

