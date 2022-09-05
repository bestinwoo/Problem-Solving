import java.io.*;
import java.util.*;
//BOJ 9466 텀 프로젝트
public class Main {
	static boolean[] visited;
	static int[] student;
	static boolean[] isCycle;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			student = new int[n+1];
			visited = new boolean[n + 1];
			isCycle = new boolean[n + 1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				student[j] = Integer.parseInt(st.nextToken());
			}

			for(int j = 1; j <= n; j++) {
				if(!visited[j]) {
					dfs(j);
				}
			}

			System.out.println(n-cnt);
		}

	}

	public static void dfs(int x) {
		visited[x] = true;
		int next = student[x];

		if(!visited[next]) {
			dfs(next);
		} else if(!isCycle[next]) {
			//사이클이 발견된 순간 해당 사이클을 돌며 cnt를 증가
			for(int i = next; i != x; i = student[i]) {
				cnt++;
			}
			cnt++;
		}
		isCycle[x] = true;
	}
}

