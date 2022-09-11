import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 6603 로또
public class Main {
	static int k;
	static int[] selected, arr;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			sb = new StringBuilder();
			arr = new int[k];
			selected = new int[6];
			visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println(sb);
		}
	}

	public static void dfs(int index, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for(int i = index; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[cnt] = arr[i];
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}

