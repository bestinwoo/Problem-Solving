import java.io.*;
import java.util.*;
//BOJ 1325 효율적인 해킹
public class Main {
	static int[] visited;
	static int[] hacked;
	static ArrayList<Integer>[] arr;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n+1];

		hacked = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		String[] inputs;
		for(int i = 0; i < m; i++) {
			inputs = br.readLine().split(" ");
			arr[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
		}

		for(int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			visited[i] = 1;
			dfs(i);
		}

		for(int i = 1; i <= n; i++) {
			if(hacked[i] == max) {
				System.out.print(i + " ");
			}
		}

	}

	public static void dfs(int x) {
		hacked[x]++;
		max = Math.max(max, hacked[x]);

		for (Integer next : arr[x]) {
			if(visited[next] == 0) {
				visited[next] = 1;
				dfs(next);
			}
		}
	}
}

