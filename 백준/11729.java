import java.io.*;
import java.util.*;
//BOJ 11729 하노이 탑 이동 순서
public class Main {
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		sb.append((1 << n) - 1).append("\n");
		hanoi(1, 3, n);
		System.out.println(sb);

	}

	public static void hanoi(int x, int y, int n) {
		if(n == 1) {
			sb.append(x).append(" ").append(y).append('\n');
			return;
		}
		hanoi(x, 6-x-y, n-1);
		sb.append(x).append(" ").append(y).append('\n');
		hanoi(6-x-y, y, n-1);
	}

}

