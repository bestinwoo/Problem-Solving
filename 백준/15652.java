import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		dfs(1, 0);
		System.out.println(sb);

	}

	public static void dfs(int num, int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = num; i <= n; i++) {
				arr[cnt] = i;
				dfs(i, cnt+1);
		}
	}
}
