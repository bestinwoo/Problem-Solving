import java.io.*;
import java.util.*;
// 16953 : A -> B
public class Main {
	static int a, b;
	static long result = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		dfs(a, 1);
		if(result == Long.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(result);
		}
	}

	public static void dfs(long num, int cnt) {
		if(num == b) {
			result = Math.min(result, cnt);
			return;
		} else if(num > b) {
			return;
		}
		dfs(num * 2, cnt + 1);
		long temp = Long.parseLong(num + "1");
		dfs(temp, cnt + 1);
	}


}
