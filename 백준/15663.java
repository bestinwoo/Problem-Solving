import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] arr;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		nums = new int[n];
		visited = new boolean[n];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(nums);
		dfs(0);
		System.out.println(sb);

	}

	public static void dfs(int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		int prev = 0;
		for (int i = 0; i < n; i++) {
			if(!visited[i] && prev != nums[i]) {
				visited[i] = true;
				arr[cnt] = nums[i];
				prev = arr[cnt];
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
