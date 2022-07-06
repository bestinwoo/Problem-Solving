import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int n, x, y, m;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		//부모 - 자식 찾을 번호
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			adj.get(num1).add(num2);
			adj.get(num2).add(num1);
		}
		dfs(x, 0);
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}

	public static void dfs(int x, int count) {
		// if(count >= n) {
		// 	return -1;
		// }

		for(int family : adj.get(x)) {
			if(family == y) {
				result = Math.min(result, count+1);
				return;
			}
			if(!visited[family]) {
				visited[family] = true;
				dfs(family, count + 1);
			}
		}
	}

}
